package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="garde")
public class Garde {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_garde")
	private Integer id;
	
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private double prix;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Chat chat;
	
	//-----------------Constructor----------------
	
	public Garde() {
		// TODO Auto-generated constructor stub
	}
	
	public Garde(LocalDate dateDebut, LocalDate dateFin, double prix, Client client, Chat chat) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prix = prix;
		this.client = client;
		this.chat = chat;
	}
	
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		prix = prix;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Chat getChat() {
		return chat;
	}
	public void setChat(Chat chat) {
		this.chat = chat;
	}

	@Override
	public String toString() {
		return "Garde [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", Prix=" + prix + ", client=" + client
				+ ", chat=" + chat + "]";
	}
	
	

}
