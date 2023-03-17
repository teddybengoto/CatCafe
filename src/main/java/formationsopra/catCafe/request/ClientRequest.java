package formationsopra.catCafe.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import formationsopra.catCafe.model.Adresse;

public class ClientRequest {
	
	@Email(message = "l'email est incorect")
	private String login;
	@NotBlank(message = "Le nom doit être saisi")
	private String nom; 
	@NotBlank(message = "Le prenom doit être saisi")
	private String prenom; 
	
	
	protected String password;

	//private Adresse adresse;
	//private String telephone;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	
	
	
	
	

}
