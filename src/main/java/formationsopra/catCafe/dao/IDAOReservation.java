package formationsopra.catCafe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import formationsopra.catCafe.model.Reservation;


public interface IDAOReservation extends JpaRepository<Reservation,Integer> {
	
	public List<Reservation> findAllByClientId(int clientId);
}
