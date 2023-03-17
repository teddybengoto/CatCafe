package formationsopra.catCafe.model;

import com.fasterxml.jackson.annotation.JsonView;

import formationsopra.catCafe.api.Views;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	@Column(length = 10)
	@JsonView(Views.Compte.class)
	private String numero;
	@Column(length=40)
	@JsonView(Views.Compte.class)
	private String voie;
	@Column(length=50)
	@JsonView(Views.Compte.class)
	private String ville;
	@Column(length=15)
	@JsonView(Views.Compte.class)
	private String cp;

	public Adresse(String numero, String voie, String ville, String cp) {
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.cp = cp;
	}
	
	public Adresse() {}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", voie=" + voie + ", ville=" + ville + ", cp=" + cp + "]";
	}

}