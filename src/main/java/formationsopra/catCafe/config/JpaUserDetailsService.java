package formationsopra.catCafe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import formationsopra.catCafe.dao.IDAOCompte;
import formationsopra.catCafe.model.Admin;
import formationsopra.catCafe.model.Compte;


@Service
public class JpaUserDetailsService implements UserDetailsService {
	@Autowired
	private IDAOCompte daoCompte;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		 Compte utilisateur = this.daoCompte
			.findByLogin(login)
			.orElseThrow(() -> new UsernameNotFoundException("Utilisateur pas trouvé."));
		
		UserBuilder userBuilder = User
				.withUsername(login)
				.password(utilisateur.getPassword());
		
		if ( utilisateur instanceof Admin) {
			userBuilder.roles("ADMIN");
		}
		
		else {
			userBuilder.roles("USER");
		}
		
		return userBuilder.build();
	}
}
