package formationsopra.catCafe.api;


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

import formationsopra.catCafe.dao.IDAOCompte;
import formationsopra.catCafe.exception.CompteBadRequestException;
import formationsopra.catCafe.exception.CompteNotFoundException;
import formationsopra.catCafe.model.Admin;
import formationsopra.catCafe.model.Adresse;
import formationsopra.catCafe.model.Client;
import formationsopra.catCafe.model.Compte;
import formationsopra.catCafe.request.AdresseRequest;
import formationsopra.catCafe.request.ClientRequest;
import formationsopra.catCafe.request.LoginRequest;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/compte")
public class CompteApiController {
	
	@Autowired
	private IDAOCompte daoCompte;
	
	
	@PostMapping("/login")
	@JsonView(Views.Compte.class)
	public Compte login(@RequestBody LoginRequest lR) {			

		return this.daoCompte.findByLoginAndPassword(lR.getLogin(), lR.getPassword());
	}
	
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
	public Client findClientById(@PathVariable int id) {
		
		return this.daoCompte.findByIdClient(id);
	}
	
	@PostMapping("/admin")
	@JsonView(Views.Compte.class)
	public Admin addAdmin(@RequestBody @Valid ClientRequest cR, BindingResult result) {
		
		if (result.hasErrors()) {
			throw new CompteBadRequestException();
		}
		
		Admin a = new Admin();
		BeanUtils.copyProperties(cR, a);
		
		
		return this.daoCompte.save(a);
	}
	
	@PostMapping("/client")
	@JsonView(Views.Compte.class)
	public Client addClient(@RequestBody @Valid ClientRequest cR, BindingResult result) {
		
		if (result.hasErrors()) {
			System.out.println("");
			throw new CompteBadRequestException();
		}
		
		Client c = new Client();
		BeanUtils.copyProperties(cR, c);
		
		return this.daoCompte.save(c);
	}

	@PutMapping("/client/{id}")
	@JsonView(Views.Compte.class)
	public Compte edit(@PathVariable int id, @Valid @RequestBody ClientRequest cR, BindingResult result) {
		
		if (result.hasErrors()) {
			throw new CompteBadRequestException();
		}
		
				
		Compte c = this.daoCompte.findById(id).orElseThrow(CompteNotFoundException::new);
		BeanUtils.copyProperties(cR, c);
		
		return this.daoCompte.save(c);
	}
	
	@PutMapping("/adresse/{id}")
	@JsonView(Views.Compte.class)
	public Client edit(@PathVariable int id, @Valid @RequestBody AdresseRequest adresse, BindingResult result) {
		
		if (result.hasErrors()) {
			System.out.println("error: "+ result.getAllErrors());
			throw new CompteBadRequestException();
		}
		
				
		Client c = this.daoCompte.findByIdClient(id);
		if(c==null)
		{
			throw new CompteNotFoundException();
		}
		
		Adresse a = new Adresse();
		
		BeanUtils.copyProperties(adresse, a);
		c.setAdresse(a);
		
		return this.daoCompte.save(c);
	}
	@PutMapping("/phone")
	@JsonView(Views.Compte.class)
	public Client edit(@RequestParam int id, @RequestParam String tel) {
		
		if (tel.isBlank()) {
			throw new CompteBadRequestException();
		}
						
		Client c = this.daoCompte.findByIdClient(id);
		if(c==null)
		{
			throw new CompteNotFoundException();
		}	
		
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
