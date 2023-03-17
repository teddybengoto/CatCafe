package formationsopra.catCafe.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import formationsopra.catCafe.model.Admin;
import formationsopra.catCafe.model.Client;
import formationsopra.catCafe.model.Compte;

public interface IDAOCompte extends JpaRepository<Compte,Integer>{

	
	@Query("select a from Admin a")
	public List<Admin> findAllAdmin();
	@Query("select c from Client c")
	public List<Client> findAllClient();
	@Query("select c from Client c where c.id = ?1")
	public Client  findByIdClient(int id);
	@Query("select a from Admin a where a.id = ?1")
	public Admin findByIdAdmin(int id);
	//@Query("select a from Admin a where a.id = ?1")
	public Compte findByLoginAndPassword(String login,String password );
	public Optional<Compte> findByLogin(String login);

}
