package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import context.Singleton;
import model.Admin;
import model.Adoption;
import model.Adresse;
import model.Chat;
import model.Client;
import model.Espace;
import model.Garde;
import model.Race;
import model.Reservation;
import model.Sexe;

public class Test {

	public static void main(String[] args) {
		
		Adresse adresse = new Adresse("12","rue","ville","cp");
		Client c1 = new Client("login","password","nom","prenom",adresse,"tel");
		Admin admin1 = new Admin("admin","admin","nom","prenom");
		
		
		Chat mousse = new Chat("mousse",Sexe.male,Race.Europeen,LocalDate.now(),"com");
		mousse.setClient(c1);
		
		Chat resident = new Chat("resident",Sexe.femelle,Race.MainCoon,false,"puce",null,LocalDate.parse("2000-12-12"),true,null,null,true);
		
		Chat adoptable = new Chat("adoptable",Sexe.femelle,Race.Autre,true,"puce",null,LocalDate.parse("2000-10-12"),true,null,null,false);
		
		Reservation r1 = new Reservation(4,LocalDate.now(),LocalDate.now(),c1,Espace.Chill);
		Garde g1 = new Garde(LocalDate.now(),LocalDate.now(),100,c1,mousse);
		
		Adoption ad1 = new Adoption(LocalDate.now(),100.0,"",c1,adoptable); 
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("catCafeUnit");
		EntityManager em = emf.createEntityManager();
		
		
		//Singleton.getInstance().getDaoCompte().save(c1);
		//Singleton.getInstance().getDaoChat().save(mousse);
		
		
		em.getTransaction().begin();
		
		em.persist(mousse);
		em.persist(resident);
		em.persist(adoptable);
		em.persist(c1);
		em.persist(admin1);
		em.persist(r1);
		em.persist(g1);
		em.persist(ad1);
		
		//em.getTransaction().commit();
		
		//em.close();
		//emf.close();
		
		System.out.println(admin1);
		System.out.println(c1);
	}
}
