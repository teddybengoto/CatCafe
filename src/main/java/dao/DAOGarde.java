package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import context.Singleton;
import model.Garde;
import model.Reservation;

public class DAOGarde implements IDAOGarde{

	@Override
	public Garde findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Garde garde = em.find(Garde.class,id);
		em.close();
		return garde;
	}

	@Override
	public List<Garde> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Garde> gardes = em.createQuery("from Garde").getResultList();
		em.close();
		return gardes;
	}

	@Override
	public Garde save(Garde garde) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		garde = em.merge(garde);
		em.getTransaction().commit();
		em.close();
		return garde;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Garde garde = em.find(Garde.class,id);
		em.getTransaction().begin();
		em.remove(garde);
		em.getTransaction().commit();
		em.close();	
	}

	@Override
	public List<Garde> findAllByClient(Integer idClient) {
		
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Query ps = em.createQuery("from Garde g where g.Client.id=:idClient");
		ps.setParameter("idClient", idClient);
		List<Garde> gardes =  ps.getResultList();
		em.close();
		return gardes;
	}

	@Override
	public List<Garde> findAllByChat(Integer idChat) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Query ps = em.createQuery("from Garde g where g.Chat.id=:idChat");
		ps.setParameter("idChat", idChat);
		List<Garde> gardes =  ps.getResultList();
		em.close();
		return gardes;
	}

}
