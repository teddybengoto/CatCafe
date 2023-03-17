package formationsopra.catCafe.model;

import com.fasterxml.jackson.annotation.JsonView;

import formationsopra.catCafe.api.Views;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_compte",columnDefinition = "ENUM('admin','client')")
@Table(name="compte")
public abstract class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	protected Integer id;
	@Column(length = 35,  nullable = false)
	@JsonView(Views.Compte.class)
	protected String login;
	@Column(length = 35,  nullable = false)
	@JsonView(Views.Compte.class)
	protected String password;
	@Column(length = 35)
	@JsonView(Views.Compte.class)
	protected String nom;
	@Column(length = 35)
	@JsonView(Views.Compte.class)
	protected String prenom;


	public Compte() {
	}

	
	public Compte(String login, String password, String nom, String prenom) {
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Compte [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + "]";
	}
	
	
	
}
