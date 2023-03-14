package api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import api.Views.Compte;
import dao.IDAOCompte;
import model.Admin;

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

	
	
	

}
