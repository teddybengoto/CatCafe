package api;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import dao.IDAOGarde;
import exception.GardeBadRequestException;
import exception.GardeNotFoundException;
import jakarta.validation.Valid;
import model.Chat;
import model.Client;
import model.Garde;
import request.GardeRequest;
import response.GardeResponse;


@RestController
@RequestMapping("/api/garde")
public class GardeApiController {
	
	@Autowired
	private IDAOGarde daoGarde;
	
	@GetMapping
	@JsonView(Views.Garde.class)
	public List<Garde> findAll() {

		return this.daoGarde.findAll();
	}
	
	//Renvoie une garde selon son ID
	@GetMapping("/{id}")
	public GardeResponse findById(@PathVariable int id) {

		Garde garde = this.daoGarde.findById(id).orElseThrow(GardeNotFoundException::new);
		GardeResponse resp = new GardeResponse();
		
		BeanUtils.copyProperties(garde, resp);

		if (garde.getClient() != null) {
			resp.setIdClient(garde.getClient().getId());
			resp.setNomClient(garde.getClient().getNom());
			resp.setPrenomClient(garde.getClient().getPrenom());
		}
		if (garde.getChat() != null)
		{
			resp.setIdChat(garde.getChat().getId());
			resp.setNomChat(garde.getChat().getNom());
		}
		return resp;
	}
	
	//Renvoie toutes les gardes pour un client (depuis son ID)
	@GetMapping("/client:{id}")
	@JsonView(Views.Garde.class)
	public List<Garde> findAllByClient(@PathVariable int id) {

			return this.daoGarde.findAllByClientId(id);
	}
	
	//Renvoie toutes les gardes pour un chat (depuis son ID)	
	@GetMapping("/chat:{id}")
	@JsonView(Views.Garde.class)
	public List<Garde> findAllByChat(@PathVariable int id) {

			return this.daoGarde.findAllByChatId(id);
	}

	//Supprime une garde (depuis son ID)	
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		try {
			
			if (!this.daoGarde.existsById(id)) {
				throw new GardeNotFoundException();
			}
			
			this.daoGarde.deleteById(id);
			
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	}

	//Ajoute une garde
	@PostMapping
	@JsonView(Views.Garde.class)
	public Garde add(@RequestBody @Valid GardeRequest req, BindingResult result) {
		
		if (result.hasErrors()) {
			throw new GardeBadRequestException();
		}
		System.out.println("initialisation");
		Garde garde = new Garde();
		Client client = new Client();
		Chat chat = new Chat();
		
		BeanUtils.copyProperties(garde, req);
		
		chat.setId(req.getChatId());
		client.setId(req.getClientId());
		
		garde.setClient(client);
		garde.setChat(chat);
		
		System.out.println("pret à sauvegarder");
		return this.daoGarde.save(garde);
	}
	
	
	//Modifier une garde par son ID
	@PutMapping("/{id}")
	@JsonView(Views.Garde.class)
	public Garde edit(@PathVariable int id, @RequestBody @Valid GardeRequest req, BindingResult result)
	{
		
		Garde garde = new Garde();
		Client client = new Client();
		Chat chat = new Chat();
		
		BeanUtils.copyProperties(garde, req);
		chat.setId(req.getChatId());
		client.setId(req.getClientId());
		
		garde.setId(id);
		garde.setClient(client);
		garde.setChat(chat);
		
		return this.daoGarde.save(garde);

	}

}
