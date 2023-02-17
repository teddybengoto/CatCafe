package model;

public class Client extends Compte {
	private Adresse adresse;
	private double telephone; 
	
	public Client(String login, String password, String nom, String prenom, Adresse adresse, double telephone) {
		super(login, password, nom, prenom);
		this.adresse = adresse;
		this.telephone = telephone;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public double getTelephone() {
		return telephone;
	}

	public void setTelephone(double telephone) {
		this.telephone = telephone;
	}

	public void reserve() {
		System.out.println(getPrenom()+" reserve pour un chat");
	}
	public void adopte() {
		
	}
	public void faitGarder() {
		
	}
	
	
	@Override
	public String toString() {
		return "User [adresse=" + adresse + ", telephone=" + telephone + ", login=" + login + ", password=" + password
				+ ", nom=" + nom + ", prenom=" + prenom + "]";
	}
}
