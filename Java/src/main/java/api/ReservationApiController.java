package api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import dao.IDAOReservation;
import exception.ReservationNotFoundExecption;
import model.Reservation;

@RestController
@RequestMapping("/api/reservation")
public class ReservationApiController {
	
	@Autowired
	private IDAOReservation daoReservation;
	
	@GetMapping
	@JsonView(Views.Reservation.class)
	public List<Reservation> findAll(){
		return this.daoReservation.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Reservation.class)
	public Reservation findById(@PathVariable int id) {
		return this.daoReservation.findById(id).orElseThrow(ReservationNotFoundExecption::new);
	}
	
	
	
	
	
}
