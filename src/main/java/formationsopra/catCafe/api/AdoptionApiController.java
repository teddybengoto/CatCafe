package formationsopra.catCafe.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formationsopra.catCafe.dao.IDAOAdoption;
import formationsopra.catCafe.exception.AdoptionBadRequestException;
import formationsopra.catCafe.exception.AdoptionNotFoundException;
import jakarta.validation.Valid;
import formationsopra.catCafe.model.Adoption;
import formationsopra.catCafe.model.Chat;
import formationsopra.catCafe.model.Client;
import formationsopra.catCafe.request.AdoptionRequest;

@RestController 
@RequestMapping("/api/adoption")
@CrossOrigin("*")
public class AdoptionApiController {

	@Autowired
	private IDAOAdoption daoAdoption;

	@GetMapping
	@JsonView(Views.Adoption.class)
	public List<Adoption> findAll(){
		return this.daoAdoption.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Adoption.class)
	public Adoption findById(@PathVariable int id){
		
		return this.daoAdoption.findById(id).orElseThrow(AdoptionNotFoundException::new);
		/*
		 * Optional<Adoption> optAdoption = this.daoAdoption.findById(id);

		if( optAdoption.isPresent()) {
			Adoption adoption = new Adoption();
			BeanUtils.copyProperties(optAdoption.get(), adoption);
			return adoption;
		}
		throw new AdoptionNotFoundException();*/
	}
	
	@GetMapping("/by-client-id/{clientId}")
	@JsonView(Views.Adoption.class)
	public List<Adoption> findAllByClientId(@PathVariable int clientId){
		return this.daoAdoption.findAllByClientId(clientId);
	}
	
	@GetMapping("/by-chat-id/{chatId}")
	@JsonView(Views.Adoption.class)
	public List<Adoption> findAllByChatId(@PathVariable int chatId){
		return this.daoAdoption.findAllByChatId(chatId);
	}

	@PostMapping
	@JsonView(Views.Adoption.class)
	public Adoption add(@RequestBody @Valid AdoptionRequest adoptionRequest, BindingResult result ) {
		if (result.hasErrors()) {
			throw new AdoptionBadRequestException();
		}

		Adoption adoption = new Adoption();
		BeanUtils.copyProperties(adoptionRequest, adoption);

		Client client = new Client();
		Chat chat = new Chat();

		client.setId(adoptionRequest.getIdClient());
		chat.setId(adoptionRequest.getIdChat());

		adoption.setClient(client);
		adoption.setChat(chat);

		return this.daoAdoption.save(adoption);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Adoption.class)
	public Adoption edit(@PathVariable int id,@RequestBody @Valid AdoptionRequest adoptionRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new AdoptionBadRequestException();
		}

		Adoption adoption = this.daoAdoption.findById(id).orElseThrow(AdoptionNotFoundException::new);
		BeanUtils.copyProperties(adoptionRequest, adoption);

		Client client = new Client();
		Chat chat = new Chat();

		client.setId(adoptionRequest.getIdClient());
		chat.setId(adoptionRequest.getIdChat());

		adoption.setClient(client);
		adoption.setChat(chat);

		return this.daoAdoption.save(adoption);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		try {
				this.daoAdoption.findById(id).orElseThrow(AdoptionNotFoundException::new);
			
			
			
			this.daoAdoption.deleteById(id);
			
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	}

}
