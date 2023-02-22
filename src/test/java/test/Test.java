package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import context.Singleton;
import model.Adresse;
import model.Chat;
import model.Client;
import model.Race;
import model.Sexe;

public class Test {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("catCafeUnit");
		EntityManager em = emf.createEntityManager();
		
		//Adresse a1 = new Adresse("12","rue","ville","cp");
		//Client c1 = new Client("login","password","nom","prenom",a1,"tel");
		
		//Chat mousse = new Chat("mousse",Sexe.male,Race.Europeen,LocalDate.now(),"com");
			
		//Singleton.getInstance().getDaoChat().save(mousse);
		
		//em.getTransaction().begin();
		
		//em.persist(mousse);
		
		//em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
