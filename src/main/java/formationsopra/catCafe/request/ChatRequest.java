package formationsopra.catCafe.request;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import formationsopra.catCafe.model.Race;
import formationsopra.catCafe.model.Sexe;

public class ChatRequest {
	
	//-------------ATTRIBUTS-------------
	@NotBlank
	private String nom;
	
	private Sexe sexe;
	
	private Race race;
	
	private boolean adoptable;
	private boolean permanent;
	private boolean sterile;
	
	private String idPuce;
	private String idTatouage;
	private String pbSante;         
	private String commentaire;
	private String image;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate naissance;
	
	private Integer clientId;
	
	//-------------GETTER SETTER-------------
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}
	
	public boolean isAdoptable() {
		return adoptable;
	}

	public void setAdoptable(boolean adoptable) {
		this.adoptable = adoptable;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public String getIdPuce() {
		return idPuce;
	}

	public void setIdPuce(String idPuce) {
		this.idPuce = idPuce;
	}

	public String getIdTatouage() {
		return idTatouage;
	}

	public void setIdTatouage(String idTatouage) {
		this.idTatouage = idTatouage;
	}

	public String getPbSante() {
		return pbSante;
	}

	public void setPbSante(String pbSante) {
		this.pbSante = pbSante;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public boolean isSterile() {
		return sterile;
	}

	public void setSterile(boolean sterile) {
		this.sterile = sterile;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}
	
	
	
	
}