package formationsopra.catCafe.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import formationsopra.catCafe.model.Chat;
import formationsopra.catCafe.model.Client;

public class GardeRequest {

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateDebut;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateFin;
	private double prix;
	private int clientId;
	private int chatId;
	
	public GardeRequest() {}
	
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

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int client) {
		this.clientId = client;
	}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chat) {
		this.chatId = chat;
	}

	

}
