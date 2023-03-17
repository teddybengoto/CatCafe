package formationsopra.catCafe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import formationsopra.catCafe.model.Adoption;


public interface IDAOAdoption extends JpaRepository <Adoption,Integer>{

	public List<Adoption> findAllByClientId(Integer id);
	public List<Adoption> findAllByChatId(Integer id);

}
