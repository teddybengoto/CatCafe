package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import context.Singleton;
import model.Adoption;

public class DAOAdoption implements IDAOAdoption{

	@Override
	public Adoption findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Adoption adoption = em.find(Adoption.class,id);
		em.close();
		return adoption;
	}

	@Override
	public List<Adoption> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Adoption> adoptions = em.createQuery("from Adoption").getResultList();
		em.close();
		return adoptions;
	}

	@Override
	public Adoption save(Adoption adoption) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		adoption = em.merge(adoption);
		em.getTransaction().commit();
		em.close();
		return adoption;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Adoption adoption = em.find(Adoption.class,id);
		em.getTransaction().begin();
		em.remove(adoption);
		em.getTransaction().commit();
		em.close();	
	}

	@Override
	public List<Adoption> findAllByClient(Integer idClient) {
		
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Query ps = em.createQuery("from adoption g where g.Client.id=:idClient");
		ps.setParameter("idClient", idClient);
		List<Adoption> adoptions =  ps.getResultList();
		em.close();
		return adoptions;
	}

	@Override
	public List<Adoption> findAllByChat(Integer idChat) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Query ps = em.createQuery("from adoption g where g.Chat.id=:idChat");
		ps.setParameter("idChat", idChat);
		List<Adoption> adoptions =  ps.getResultList();
		em.close();
		return adoptions;
	}

}
