package formationsopra.catCafe.request;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Positive;
import formationsopra.catCafe.model.Espace;

public class ReservationRequest {

	@Positive(message="L'effectif de réservation doit être supérieure à 0.")
	private int effectif ;
	
	private Espace espace;
	
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime heure;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate jour;
	
	private int client_id;
	
	
	

	public int getEffectif() {
		return effectif;
	}

	public void setEffectif(int effectif) {
		this.effectif = effectif;
	}

	public LocalDate getJour() {
		return jour;
	}

	public void setJour(LocalDate jour) {
		this.jour = jour;
	}

	public LocalTime getHeure() {
		return heure;
	}

	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public Espace getEspace() {
		return espace;
	}

	public void setEspace(Espace espace) {
		this.espace = espace;
	}

	


	
	
	
}
