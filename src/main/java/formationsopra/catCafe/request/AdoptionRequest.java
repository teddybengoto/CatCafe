package formationsopra.catCafe.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AdoptionRequest {
	
	private double prix;
	private String condition;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	private int idChat;
	
	private int idClient;
	
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getIdChat() {
		return idChat;
	}
	public void setIdChat(int idChat) {
		this.idChat = idChat;
	}
	
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	
	
}
