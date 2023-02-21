package dao;

import java.util.List;

import model.Adoption;
import model.Chat;
import model.Reservation;

public interface IDAOAdoption extends IDAO<Adoption,Integer>{
	
	public List<Adoption> findAllByClient(Integer idClient);
	public List<Adoption> findAllByChat(Integer idChat);

}
