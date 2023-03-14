package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import dao.IDAOAdoption;
import dao.IDAOChat;
import dao.IDAOCompte;
import dao.IDAOGarde;
import dao.IDAOReservation;
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
		/*
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		IDAOAdoption daoAdoption = context.getBean(IDAOAdoption.class);
		IDAOChat daoChat = context.getBean(IDAOChat.class);
		IDAOCompte daoCompte = context.getBean(IDAOCompte.class);
		IDAOGarde daoGarde = context.getBean(IDAOGarde.class);
		IDAOReservation daoReservation = context.getBean(IDAOReservation.class);
		

		
		Adresse adresse = new Adresse("12","rue","ville","cp");
		Client c1 = new Client("login","password","nom","prenom",adresse,"tel");
		Admin admin1 = new Admin("admin","admin","nom","prenom");


		Chat mousse = new Chat("mousse",Sexe.male,Race.Europeen,LocalDate.now(),"com");
		mousse.setClient(c1);

		Chat resident = new Chat("resident",Sexe.femelle,Race.MainCoon,false,"puce",null,LocalDate.parse("2000-12-12"),true,null,null,true);

		Chat adoptable = new Chat("adoptable",Sexe.femelle,Race.Autre,true,"puce",null,LocalDate.parse("2000-10-12"),true,null,null,false);

		Reservation r1 = new Reservation(4,LocalDate.now(),LocalTime.now(),c1,Espace.Chill);
		Garde g1 = new Garde(LocalDate.now(),LocalDate.now(),100,c1,mousse);

		Adoption ad1 = new Adoption(LocalDate.now(),100.0,"",c1,adoptable); 

		daoCompte.save(c1);
		daoCompte.save(admin1);

		daoChat.save(mousse);
		daoChat.save(resident);
		daoChat.save(adoptable);
		
		daoReservation.save(r1);
		daoGarde.save(g1);
		daoAdoption.save(ad1);

		List<Chat> chats= daoChat.findAll();
		for(Chat c:chats){
			System.out.println(c.getNom());
		}


		
*/
	}
}
