package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import context.Singleton;
import model.Chat;

public class DAOChat implements IDAOChat{

	@Override
	public Chat findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Chat chat = em.find(Chat.class,id);
		em.close();
		return chat;
	}

	@Override
	public List<Chat> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Chat> chats = em.createQuery("from Chat").getResultList();
		em.close();
		return chats;
	}

	@Override
	public Chat save(Chat chat) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		chat = em.merge(chat);
		em.getTransaction().commit();
		em.close();
		return chat;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Chat chat = em.find(Chat.class,id);
		em.getTransaction().begin();
		em.remove(chat);
		em.getTransaction().commit();
		em.close();	
	}

	@Override
	public List<Chat> findAllByClient(Integer idClient) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Query ps = em.createQuery("from Chat c where c.client.id=:idClient");
		ps.setParameter("idClient", idClient);
		List<Chat> chats = ps.getResultList();
		em.close();
		return chats;
	}

}
