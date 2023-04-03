package formationsopra.catCafe.api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formationsopra.catCafe.dao.IDAOReservation;
import formationsopra.catCafe.exception.ReservationBadRequestException;
import formationsopra.catCafe.exception.ReservationNotFoundException;
import jakarta.validation.Valid;
import formationsopra.catCafe.model.Client;
import formationsopra.catCafe.model.Reservation;
import formationsopra.catCafe.request.ReservationRequest;
import formationsopra.catCafe.config.AccessAutorisation;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin("*")
public class ReservationApiController {
	
	@Autowired
	private IDAOReservation daoReservation;

	@Autowired
	private AccessAutorisation accessAutorisation;
	
	@GetMapping
	@JsonView(Views.Reservation.class)
	public List<Reservation> findAll(){
		return this.daoReservation.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Reservation.class)
	public Reservation findById(@PathVariable int id) {

		Reservation resevation = this.daoReservation.findById(id).orElseThrow(ReservationNotFoundException::new);

		if (accessAutorisation.isAllowed(resevation.getClient().getId().toString())) {
			return resevation;
		}
			throw new ReservationBadRequestException();
		
	}
	
	
	@GetMapping("/by-client-id/{clientId}")
	@JsonView(Views.Reservation.class)
	public List<Reservation> findAllByClientId(@PathVariable int clientId) {
		return this.daoReservation.findAllByClientId(clientId);
	}
	
	
	
	@PostMapping
	@JsonView(Views.Reservation.class)
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation add(@RequestBody @Valid ReservationRequest reservationRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new ReservationBadRequestException();
		}
	
		Reservation reservation = new Reservation();
		
		BeanUtils.copyProperties(reservationRequest, reservation);
		Client client = new Client();
		client.setId(reservationRequest.getClient_id());
		
		reservation.setClient(client);
		
		return this.daoReservation.save(reservation);
	}
	
	
	@PutMapping("/{id}")
	@JsonView(Views.Reservation.class)
	public Reservation edit(@PathVariable int id, @Valid @RequestBody ReservationRequest reservationRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new ReservationBadRequestException();
		}
		
		Reservation reservation = this.daoReservation.findById(id).orElseThrow(ReservationNotFoundException::new);
		
		BeanUtils.copyProperties(reservationRequest, reservation);
		
		return this.daoReservation.save(reservation);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		try {
			this.daoReservation.deleteById(id);
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	}
	
	
}
