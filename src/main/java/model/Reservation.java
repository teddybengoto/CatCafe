package model;

import java.time.LocalDate;

public class Reservation {

    private int effectif ;
    private LocalDate jour;
    private LocalDate heure;
    private Client client;
    private Espace espace;




    public Reservation(int effectif, LocalDate jour, LocalDate heure, Client client, Espace espace) {
        this.effectif = effectif;
        this.jour = jour;
        this.heure = heure;
        this.client = client;
        this.espace = espace;
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

   
    
}
