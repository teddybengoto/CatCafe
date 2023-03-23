package formationsopra.catCafe.config;

import org.springframework.security.core.context.SecurityContextHolder;


public class AccessAutorisation {


    public AccessAutorisation (){}
	

    public boolean isAllowed(String idOwner) {

		if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().equals("[ROLE_ADMIN]")) {
			return true;
		} else {
			if (idOwner.equals(SecurityContextHolder.getContext().getAuthentication().getCredentials()) ) {

				return true;
			} else {
				return false;
			}
		}
	}

    
}
