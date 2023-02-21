package dao;

import java.util.List;

import model.Chat;
import model.Garde;
import model.Reservation;

public interface IDAOGarde extends IDAO<Garde,Integer>{
	
	public List<Garde> findAllByClient(Integer idClient);
	public List<Garde> findAllByChat(Integer idGarde);

}
