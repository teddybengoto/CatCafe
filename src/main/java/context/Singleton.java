package context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOAdoption;
import dao.DAOChat;
import dao.DAOCompte;
import dao.DAOGarde;
import dao.DAOReservation;
import dao.IDAOAdoption;
import dao.IDAOChat;
import dao.IDAOCompte;
import dao.IDAOGarde;
import dao.IDAOReservation;

public class Singleton {
	
	private IDAOAdoption daoAdoption = new DAOAdoption();
	private IDAOChat daoChat = new DAOChat();
	private IDAOCompte daoCompte = new DAOCompte();
	private IDAOGarde daoGarde = new DAOGarde();
	private IDAOReservation daoReservation = new DAOReservation();
	
	
	private EntityManagerFactory emf= Persistence.createEntityManagerFactory("catCafeUnit");
	private static Singleton instance;
	
	private Singleton() {}


	public static Singleton getInstance() {
		if(instance==null) 
		{
			instance=new Singleton();
		}
		return instance;
	}


	public IDAOAdoption getDaoAdoption() {
		return daoAdoption;
	}


	public void setDaoAdoption(IDAOAdoption daoAdoption) {
		this.daoAdoption = daoAdoption;
	}


	public IDAOChat getDaoChat() {
		return daoChat;
	}


	public void setDaoChat(IDAOChat daoChat) {
		this.daoChat = daoChat;
	}


	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}


	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}


	public IDAOGarde getDaoGarde() {
		return daoGarde;
	}


	public void setDaoGarde(IDAOGarde daoGarde) {
		this.daoGarde = daoGarde;
	}


	public IDAOReservation getDaoReservation() {
		return daoReservation;
	}


	public void setDaoReservation(IDAOReservation daoReservation) {
		this.daoReservation = daoReservation;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	
}
