package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Chat {
	
	//---------------------------------Attribut------------------------
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cat")
	private Integer id;
	
	@Column(nullable=false)
	private String nom;
	
	@Column(name="sexe",columnDefinition = "ENUM('male','femelle')",nullable=false)
	@Enumerated(EnumType.STRING)
	private Sexe sexe;
	
	@Column(name="race",columnDefinition = "ENUM('Europeen','Ragdoll','MainCoon','Persan',"
			+ "'Sphynx','SacreDeBirmanie','BritishShorthair',"
			+ "'Norvegien','Chartreux','Siamois','Abyssin','Bengal','Autre')",nullable=false)
	@Enumerated(EnumType.STRING)
	private Race race;
	private boolean adoptable;
	private String idPuce;
	private String idTatouage;
	private LocalDate naissance;
	private boolean sterile;  
	private String pbSante;         
	private String commentaire;
	private boolean permanent;
	
	@OneToOne(mappedBy = "chat")
	private Client user;
	
	@OneToOne(mappedBy = "chat")
	private Adoption adoption;
	
	@OneToMany
	private List<Garde> garde;

	
	
	//---------------------------------Constructeur------------------------
	
	public Chat(String nom, Sexe sexe, Race race, LocalDate naissance,String commentaire) {
		this.nom = nom;
		this.sexe = sexe;
		this.race = race;
		this.naissance = naissance;
		this.commentaire = commentaire;
	}

	public Chat(String nom, Sexe sexe, Race race, boolean adoptable, String idPuce, String idTatouage,
			LocalDate naissance, boolean sterile, String pbSante,
			String commentaire, boolean permanent) {
		this.nom = nom;
		this.sexe = sexe;
		this.race = race;
		this.adoptable = adoptable;
		this.idPuce = idPuce;
		this.idTatouage = idTatouage;
		this.naissance = naissance;
		this.sterile = sterile;
		this.pbSante = pbSante;
		this.commentaire = commentaire;
		this.permanent = permanent;
	}
	
    public Chat() {}

    //---------------------------------String------------------------
    
	public String toString() {
		return "Chat [nom=" + nom + ", \nsexe=" + sexe + ", \nrace=" + race + ", \nadoptable=" + adoptable + ", \nid=" + id
				+ ", \nidPuce=" + idPuce + ", \nidTatouage=" + idTatouage + ", \nnaissance=" + naissance + ", \nsterile="
				+ sterile + ", \npbSante=" + pbSante
				+ ", \ncommentaire=" + commentaire + ", \npermanent=" + permanent + "]";
	}

	//---------------------------------Getter Setter------------------------
	
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Sexe getSexe() {
		return this.sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public Race getRace() {
		return this.race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public boolean isAdoptable() {
		return this.adoptable;
	}

	public boolean getAdoptable() {
		return this.adoptable;
	}

	public void setAdoptable(boolean adoptable) {
		this.adoptable = adoptable;
	}

	public Integer getId() {
		return this.id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getIdPuce() {
		return this.idPuce;
	}

	public void setIdPuce(String idPuce) {
		this.idPuce = idPuce;
	}

	public String getIdTatouage() {
		return this.idTatouage;
	}

	public void setIdTatouage(String idTatouage) {
		this.idTatouage = idTatouage;
	}

	public LocalDate getNaissance() {
		return this.naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	public boolean isSterile() {
		return this.sterile;
	}

	public boolean getSterile() {
		return this.sterile;
	}

	public void setSterile(boolean sterile) {
		this.sterile = sterile;
	}

	public String getPbSante() {
		return this.pbSante;
	}

	public void setPbSante(String pbSante) {
		this.pbSante = pbSante;
	}

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public boolean isPermanent() {
		return this.permanent;
	}

	public boolean getPermanent() {
		return this.permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public Client getUser() {
		return this.user;
	}

	public void setUser(Client user) {
		this.user = user;
	}

	
	public Adoption getAdoption() {
		return this.adoption;
	}

	public void setAdoption(Adoption adoption) {
		this.adoption = adoption;
	}
	
/*
	public List<Garde> getGarde() {
		return this.garde;
	}

	public void setGarde(List<Garde> garde) {
		this.garde = garde;
	}
*/



}