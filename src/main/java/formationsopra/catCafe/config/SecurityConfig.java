package formationsopra.catCafe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import formationsopra.catCafe.config.jwt.JwtHeaderAuthorizationFilter;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, JwtHeaderAuthorizationFilter jwtFilter) throws Exception {
//		http.formLogin(); // Activer l'authentification par formulaire de connexion
		http.httpBasic(); // Activer l'authentification par Http Basic
		
		// Pour gérer les différents accès
		http.authorizeHttpRequests(authorize -> {
//			authorize.requestMatchers("/api/produit").authenticated();
			
//			authorize.requestMatchers("/api/produit").permitAll();
			
//			authorize.requestMatchers("/api/produit").hasRole("USER");
//			authorize.requestMatchers("/api/produit").hasAnyRole("USER", "ADMIN");
//			authorize.requestMatchers("/api/**").hasRole("ADMIN");
			
			// On sera plus générique ici grâce à PrePost = true
			authorize.requestMatchers("/api/compte/**").permitAll();
			authorize.requestMatchers("/api/**").authenticated();
		});
		
		// Par défaut, Spring Security active la protection contre les attaques CSRF
		http.csrf().disable(); // Permet de désactiver cette protection
		
		// Positionner le filtre
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
		// Désactiver la session utilisateur par cookie, puisque c'est plus nécessaire avec le jeton JWT
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		return http.build();
	}
	
	@Bean
    public static MethodSecurityExpressionHandler methodExpressionHandler(RoleHierarchy roleHierarchy) {
        DefaultMethodSecurityExpressionHandler hdlr = new DefaultMethodSecurityExpressionHandler();

        hdlr.setRoleHierarchy(roleHierarchy);

        return hdlr;
    }
	
	@Bean
	public RoleHierarchy roleHierarchy() {
		String hierarchy = """
			ROLE_ADMIN > ROLE_USER
		""";
		RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
		
		roleHierarchy.setHierarchy(hierarchy);
		
		return roleHierarchy;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// Grace à ce Bean, on pourra injecter (dans nos contrôleurs par exemple) un AuthenticationManager
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
//	@Bean
	public UserDetailsService inMemory(PasswordEncoder passwordEncoder) {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		System.out.println(passwordEncoder.encode("Not24Get"));
		
		manager.createUser(
			User
				.withUsername("user")
				// On peut lui préciser, en préfix de mot de passe, le type d'encodage
				// NoOperator (noop) => Pas d'encodage
				.password(passwordEncoder.encode("Not24Get"))
				.roles("USER")
				.build()
		);
		
		manager.createUser(
			User
				.withUsername("admin")
				.password(passwordEncoder.encode("Not24Get"))
				.roles("ADMIN")
				.build()
		);
		
		return manager;
	}
}
