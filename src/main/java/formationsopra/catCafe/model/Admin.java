package formationsopra.catCafe.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends Compte {



    public Admin(String login, String password, String nom, String prenom) {
    	super(login, password, nom, prenom);
    }    
    
    public Admin() {}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom
				+ "]";
	}

    

}