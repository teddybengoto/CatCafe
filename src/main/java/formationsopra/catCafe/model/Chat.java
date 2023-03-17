package formationsopra.catCafe.model;

import java.time.LocalDate;
import java.util.List;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;




@Entity
public class Chat {
	
	//---------------------------------Attribut------------------------
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_chat")
	@JsonView(Views.Common.class)
	private Integer id;
	
	@Column(nullable=false)
	@JsonView(Views.Chat.class)
	private String nom;
	
	@Column(name="sexe",columnDefinition = "ENUM('male','femelle')",nullable=false)
	@Enumerated(EnumType.STRING)
	@JsonView(Views.Chat.class)
	private Sexe sexe;
	
	@Column(name="race",columnDefinition = "ENUM('Europeen','Ragdoll','MainCoon','Persan',"
			+ "'Sphynx','SacreDeBirmanie','BritishShorthair',"
			+ "'Norvegien','Chartreux','Siamois','Abyssin','Bengal','Autre')",nullable=false)
	@Enumerated(EnumType.STRING)
	@JsonView(Views.Chat.class)
	private Race race;
	
	@JsonView(Views.Chat.class)
	private boolean adoptable;
	@JsonView(Views.Chat.class)
	private boolean permanent;
	@JsonView(Views.Chat.class)
	private boolean sterile; 
	
	@JsonView(Views.Chat.class)
	private String idPuce;
	@JsonView(Views.Chat.class)
	private String idTatouage;
	
	@JsonView(Views.Chat.class)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate naissance;
	
	@JsonView(Views.Chat.class)
	private String pbSante;    
	@JsonView(Views.Chat.class)
	private String commentaire;
	@JsonView(Views.Chat.class)
	private String image;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	@JsonView(Views.Chat.class)
	private Client client;
	
	@OneToOne(mappedBy = "chat")
	private Adoption adoption;
	
	@OneToMany(mappedBy = "chat")
	private List<Garde> garde;

	
	
	//---------------------------------Constructeur------------------------
	
	/*public Chat(String nom, Sexe sexe, Race race, LocalDate naissance,String commentaire) {
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
	}*/
	
    public Chat() {}

    //---------------------------------String------------------------
    
	public String toString() {
		return "Chat [nom=" + nom + ", \nsexe=" + sexe + ", \nrace=" + race + ", \nadoptable=" + adoptable + ", \nid=" + id
				+ ", \nidPuce=" + idPuce + ", \nidTatouage=" + idTatouage + ", \nnaissance=" + naissance + ", \nsterile="
				+ sterile + ", \npbSante=" + pbSante
				+ ", \ncommentaire=" + commentaire + ", \npermanent=" + permanent + "]";
	}

	//---------------------------------Getter Setter------------------------

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Garde> getGarde() {
		return this.garde;
	}

	public void setGarde(List<Garde> garde) {
		this.garde = garde;
	}
	


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

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client user) {
		this.client = user;
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