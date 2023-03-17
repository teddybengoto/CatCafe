package formationsopra.catCafe.model;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import formationsopra.catCafe.api.Views;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="garde")
public class Garde {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_garde")
	@JsonView(Views.Common.class)
	private Integer id;
	@JsonView(Views.Garde.class)
	@JsonFormat(pattern ="dd/MM/yyyy")
	@Column(name="dateDebut", nullable = false)
	private LocalDate dateDebut;
	@JsonView(Views.Garde.class)
	@JsonFormat(pattern ="dd/MM/yyyy")
	@Column(name="dateFin", nullable = false)
	private LocalDate dateFin;
	@JsonView(Views.Garde.class)
	@Column(name="prix", nullable = false)
	private double prix;
	@ManyToOne
	@JoinColumn(name="client", nullable = false)
	@JsonView(Views.Garde.class)
	private Client client;
	@ManyToOne
	@JoinColumn(name="chat", nullable = false)
	@JsonView(Views.Garde.class)
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
	//-----------------Constructor----------------
	
	
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
		this.prix = prix;
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
