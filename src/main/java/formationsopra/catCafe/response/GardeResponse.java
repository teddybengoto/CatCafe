package formationsopra.catCafe.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import formationsopra.catCafe.model.Chat;
import formationsopra.catCafe.model.Client;

public class GardeResponse {
	
	private Integer id;
	@JsonFormat(pattern ="yyyy-MM-dd")
	private LocalDate dateDebut;
	@JsonFormat(pattern ="yyyy-MM-dd")
	private LocalDate dateFin;
	private double prix;
	private int idClient;
	private int idChat;
	private String nomClient;
	private String prenomClient;
	private String nomChat;
	
	//-----------------Constructor---------------------------------
	
	public GardeResponse() {
	}
	
	
	
	//-----------------Getter & setter-----------------------------
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		this.prix = prix;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public int getIdChat() {
		return idChat;
	}
	public void setIdChat(int idChat) {
		this.idChat = idChat;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getNomChat() {
		return nomChat;
	}
	public void setNomChat(String nomChat) {
		this.nomChat = nomChat;
	}
	

}
