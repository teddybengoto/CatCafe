package model;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name ="adoption")
public class Adoption {

	
	//-----------Attributs-----------------
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_adoption")
	private Integer id;
	@Column(name="date_adoption")
	private LocalDate date;
	@Column(name="prix_adoption")
	private double prix;
	private String Condition;
	@ManyToOne
	private Client client;
	@OneToOne
	private Chat chat;
	
	
	//---------Constructor-------------
	
	public Adoption() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Adoption(LocalDate date, double prix, String condition,Client client, Chat chat) {
		this.date = date;
		this.prix = prix;
		Condition = condition;
		this.client = client;
		this.chat = chat;
	}

	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getCondition() {
		return Condition;
	}

	public void setCondition(String condition) {
		Condition = condition;
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
	

	
}