package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Adoption;
import model.Chat;
import model.Reservation;

public interface IDAOAdoption extends JpaRepository <Adoption,Integer>{

	public List<Adoption> findAllByClientId(Integer id);
	public List<Adoption> findAllByChatId(Integer id);

}
