package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import context.Singleton;
import model.Reservation;

public class DAOReservation implements IDAOReservation{

	@Override
	public Reservation findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Reservation reservation = em.find(Reservation.class,id);
		em.close();
		return reservation;
	}

	@Override
	public List<Reservation> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Reservation> reservations = em.createQuery("from Reservation").getResultList();
		em.close();
		return reservations;
	}

	@Override
	public Reservation save(Reservation reservation) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		reservation = em.merge(reservation);
		em.getTransaction().commit();
		em.close();
		return reservation;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Reservation reservation = em.find(Reservation.class,id);
		em.getTransaction().begin();
		em.remove(reservation);
		em.getTransaction().commit();
		em.close();	
	}

	@Override
	public List<Reservation> findAllByClient(Integer idClient) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Query ps = em.createQuery("from Reservation r where r.client.id=:idClient");
		ps.setParameter("idClient", idClient);
		List<Reservation> reservations = ps.getResultList();
		em.close();
		return reservations;
	}

	

}
