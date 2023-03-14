package api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import dao.IDAOCompte;
import exception.ClientBadRequestException;
import exception.ClientNotFoundException;
import exception.CompteNotFoundException;
import jakarta.validation.Valid;
import model.Admin;
import model.Adresse;
import model.Client;
import model.Compte;
import request.AdresseRequest;
import request.ClientRequest;

@RestController
@RequestMapping("/api/compte")
public class CompteApiController {
	
	@Autowired
	private IDAOCompte daoCompte;
		
	
	@GetMapping("/admin")
	@JsonView(Views.Compte.class)
	public List<Admin> findAllAdmin() {
		return this.daoCompte.findAllAdmin();
	}
	
	@GetMapping("/admin/{id}")
	@JsonView(Views.Compte.class)
	public Admin findAdminById(@PathVariable int id) {
		return this.daoCompte.findByIdAdmin(id);
	}
	
	@GetMapping("/client")
	@JsonView(Views.Compte.class)
	public List<Client> findAllClient() {
		return this.daoCompte.findAllClient();
	}
	
	@GetMapping("/client/{id}")
	@JsonView(Views.Compte.class)
	public Optional<Client> findClientById(@PathVariable int id) {
		return this.daoCompte.findByIdClient(id);
	}
	
	@PostMapping("/admin")
	@JsonView(Views.Compte.class)
	public Admin addAdmin(@RequestBody @Valid ClientRequest cR, BindingResult result) {
		
		if (result.hasErrors()) {
			throw new ClientBadRequestException();
		}
		
		Admin a = new Admin();
		BeanUtils.copyProperties(cR, a);
		
		
		return this.daoCompte.save(a);
	}
	
	@PostMapping("/client")
	@JsonView(Views.Compte.class)
	public Client addClient(@RequestBody @Valid ClientRequest cR, BindingResult result) {
		
		if (result.hasErrors()) {
			throw new ClientBadRequestException();
		}
		
		Client c = new Client();
		BeanUtils.copyProperties(cR, c);
		
		return this.daoCompte.save(c);
	}

	@PutMapping("/client/{id}")
	@JsonView(Views.Compte.class)
	public Compte edit(@PathVariable int id, @Valid @RequestBody ClientRequest cR, BindingResult result) {
		
		if (result.hasErrors()) {
			throw new ClientBadRequestException();
		}
		
				
		Compte c = this.daoCompte.findById(id).orElseThrow(ClientNotFoundException::new);
		BeanUtils.copyProperties(cR, c);
		
		return this.daoCompte.save(c);
	}
	
	@PutMapping("/Addresse/{id}")
	@JsonView(Views.Compte.class)
	public Client edit(@PathVariable int id, @Valid @RequestBody AdresseRequest adresse, BindingResult result) {
		
		if (result.hasErrors()) {
			System.out.println("error: "+ result.getAllErrors());
			throw new ClientBadRequestException();
		}
		
				
		Client c = this.daoCompte.findByIdClient(id).orElseThrow(ClientNotFoundException::new);
		Adresse a = new Adresse();
		
		BeanUtils.copyProperties(adresse, a);
		c.setAdresse(a);
		
		return this.daoCompte.save(c);
	}
	@PutMapping("/phone")
	@JsonView(Views.Compte.class)
	public Client edit(@RequestParam int id, @RequestParam String tel) {
		
		if (tel.isBlank()) {
			throw new ClientBadRequestException();
		}
						
		Client c = this.daoCompte.findByIdClient(id).orElseThrow(ClientNotFoundException::new);
		
		c.setTelephone(tel);
		
		return this.daoCompte.save(c);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		try {
			
			if (!this.daoCompte.existsById(id)) {
				throw new CompteNotFoundException();
			}
			
			this.daoCompte.deleteById(id);
			
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	}
	


	
	
	

}
