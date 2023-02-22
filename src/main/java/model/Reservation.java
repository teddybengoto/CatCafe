package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_reservation")
	private Integer id;
	
    private int effectif ;
    
    @Column(nullable=false)
    private LocalDate jour;
    
    @Column(nullable=false)
    private LocalDate heure;
    
    @ManyToOne
	@JoinColumn(name="client",nullable = false)
    private Client client;
    
    @Column(name="sexe",columnDefinition = "ENUM('Jeu', 'Coworking', 'Chill', 'SalonDeThe')",nullable=false)
	@Enumerated(EnumType.STRING)
    private Espace espace;


    public Reservation() {}
    public Reservation(int effectif, LocalDate jour, LocalDate heure, Client client, Espace espace) {
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

    public LocalDate getHeure() {
        return this.heure;
    }

    public void setHeure(LocalDate heure) {
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
