package formationsopra.catCafe.model;


import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import formationsopra.catCafe.api.Views;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_reservation")
	@JsonView(Views.Common.class)
	private Integer id;
	
	@JsonView(Views.Reservation.class)
    private int effectif ;
    
    @Column(nullable=false)
    @JsonView(Views.Reservation.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate jour;
    
    @Column(nullable=false)
    @JsonView(Views.Reservation.class)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime heure;
    
    @ManyToOne
	@JoinColumn(name="id_client",nullable = false)
    @JsonView(Views.Reservation.class)
    private Client client;
    
    @Column(name="espace",columnDefinition = "ENUM('Jeu', 'Coworking', 'Chill', 'SalonDeThe')",nullable=false)
	@Enumerated(EnumType.STRING)
    @JsonView(Views.Reservation.class)
    private Espace espace;


    public Reservation() {}
    public Reservation(int effectif, LocalDate jour, LocalTime heure, Client client, Espace espace) {
		this.effectif = effectif;
		this.jour = jour;
		this.heure = heure;
		this.client = client;
		this.espace = espace;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getEffectif() {
        return this.effectif;
    }

    public void setEffectif(int effectif) {
        this.effectif = effectif;
    }

    public LocalDate getJour() {
        return this.jour;
    }

    public void setJour(LocalDate jour) {
        this.jour = jour;
    }

    public LocalTime getHeure() {
        return this.heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public Espace getEspace() {
		return espace;
	}

	public void setEspace(Espace espace) {
		this.espace = espace;
	}
	
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", effectif=" + effectif + ", jour=" + jour + ", heure=" + heure + ", client="
				+ client + ", espace=" + espace + "]";
	}

   
    
}
