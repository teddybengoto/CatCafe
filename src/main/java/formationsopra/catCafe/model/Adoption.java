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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name ="adoption")
public class Adoption {

	
	//-----------Attributs-----------------
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_adoption")
	@JsonView(Views.Common.class)
	private Integer id;
	@Column(name="date_adoption")
	@JsonView(Views.Adoption.class)
    @JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;
	@Column(name="prix_adoption", nullable = false, columnDefinition = "DECIMAL(5,2)")
	@JsonView(Views.Adoption.class)
	private double prix;
	@Column(name="condition_adoption")
	@JsonView(Views.Adoption.class)
	private String condition;
	@ManyToOne
	@JoinColumn(name="id_client", nullable = false)
	@JsonView(Views.Adoption.class)
	private Client client;
	@OneToOne
	@JoinColumn(name="id_chat", nullable = false)
	@JsonView(Views.Adoption.class)
	private Chat chat;
	
	
	//---------Constructor-------------
	
	public Adoption() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Adoption(LocalDate date, double prix, String condition,Client client, Chat chat) {
		this.date = date;
		this.prix = prix;
		this.condition = condition;
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
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
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
		return "Adoption [id=" + id + ", date=" + date + ", prix=" + prix + ", Condition=" + condition + ", client="
				+ client + ", chat=" + chat + "]";
	}
	
	
	

	
}