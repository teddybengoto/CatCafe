package dao;

import java.util.List;

import model.Chat;
import model.Reservation;

public interface IDAOReservation extends IDAO<Reservation,Integer> {
	
	public List<Reservation> findAllByClient(Integer idClient);
}
