package formationsopra.catCafe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import formationsopra.catCafe.model.Chat;




public interface IDAOChat extends JpaRepository<Chat,Integer> {
	
	public List<Chat> findAllByClientId(Integer id);
	
	@Query("select c from Chat c where c.adoptable=1")
	public List<Chat> findAllAdoptable();
	
	@Query("select c from Chat c where c.permanent=1")
	public List<Chat> findAllPermanent();
}
