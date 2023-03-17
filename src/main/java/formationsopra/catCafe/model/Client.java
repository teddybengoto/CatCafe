package formationsopra.catCafe.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import formationsopra.catCafe.api.Views;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


@Entity
@DiscriminatorValue("client")
public class Client extends Compte {

	@Embedded
	@JsonView(Views.Compte.class)
	private Adresse adresse;
	@JsonView(Views.Compte.class)
	private String telephone; 

	@OneToMany(mappedBy = "client")
	private List <Chat> chat;

	@OneToMany(mappedBy = "client")
	private List <Adoption> adoption;
	
	@OneToMany(mappedBy = "client")
	private List <Garde> garde;

		
	@OneToMany(mappedBy = "client")
	private List <Reservation> reservation;
	

	public Client() {
	}


	public Client(String login, String password, String nom, String prenom, Adresse adresse, String telephone) {
		super(login, password, nom, prenom);
		this.adresse = adresse;
		this.telephone = telephone;
	}

	public List<Reservation> getReservation() {
		return this.reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}


	public List<Garde> getGarde() {
		return this.garde;
	}

	public void setGarde(List<Garde> garde) {
		this.garde = garde;
	}

	public List<Adoption> getAdoption() {
		return this.adoption;
	}

	public void setAdoption(List<Adoption> adoption) {
		this.adoption = adoption;
	}


	public List<Chat> getChat() {
		return this.chat;
	}

	public void setChat(List<Chat> chat) {
		this.chat = chat;
	}
	

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
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
