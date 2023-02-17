package model;

import java.time.LocalDate;

public class Garde {
	
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private double Prix;
	private Client client;
	private Chat chat;
	
	
	public Garde(LocalDate dateDebut, LocalDate dateFin, double prix, Client client, Chat chat) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		Prix = prix;
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
		return Prix;
	}
	public void setPrix(double prix) {
		Prix = prix;
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
		return "Garde [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", Prix=" + Prix + ", client=" + client
				+ ", chat=" + chat + "]";
	}
	
	

}
