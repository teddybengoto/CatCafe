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

import formationsopra.catCafe.dao.IDAOChat;
import formationsopra.catCafe.exception.ChatBadRequestException;
import formationsopra.catCafe.exception.ChatNotFoundException;
import formationsopra.catCafe.model.Chat;
import formationsopra.catCafe.model.Client;
import formationsopra.catCafe.request.ChatRequest;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/chat")
@CrossOrigin("*")
public class ChatApiController {
	
	@Autowired
	private IDAOChat daoChat;
	
	//----------FindAll----------
	@GetMapping
	@JsonView(Views.Chat.class)
	public List<Chat> findAll() {
		return this.daoChat.findAll();
	}
	
	@GetMapping("/adoptable")
	@JsonView(Views.Chat.class)
	public List<Chat> findAllAdoptable() {
		return this.daoChat.findAllAdoptable();
	}
	
	@GetMapping("/permanent")
	@JsonView(Views.Chat.class)
	public List<Chat> findAllPermanent() {
		return this.daoChat.findAllPermanent();
	}
	
	//----------FindById----------
	@GetMapping("/{id}")
	@JsonView(Views.Chat.class)
	public Chat findById(@PathVariable int id){
		return this.daoChat.findById(id).orElseThrow(ChatNotFoundException::new);
		
	}
	
	//
	@GetMapping("/by-client-id/{clientId}")
	@JsonView(Views.Chat.class)
	public List<Chat> findAllByClientId(@PathVariable int clientId){
		return this.daoChat.findAllByClientId(clientId);
	}
	
	
	//----------ADD----------
	@PostMapping
	@JsonView(Views.Chat.class)
	public Chat add(@RequestBody @Valid ChatRequest chatRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new ChatBadRequestException();
		}
		
		Chat chat = new Chat();
		BeanUtils.copyProperties(chatRequest, chat);
		if(chatRequest.getClientId() != null) {
			Client client = new Client();
			client.setId(chatRequest.getClientId());
			chat.setClient(client);
		}
		
		else {
			chat.setClient(null);
		}
		
		return this.daoChat.save(chat);
		
	}
	
	//----------EDIT----------
	@PutMapping("/{id}")
	@JsonView(Views.Chat.class)
	public Chat edit(@PathVariable int id, @RequestBody @Valid ChatRequest chatRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new ChatBadRequestException();
		}
		
		Chat chat = this.daoChat.findById(id).orElseThrow(ChatNotFoundException::new);
		
		BeanUtils.copyProperties(chatRequest, chat);
		System.out.println(chatRequest.getClientId());
		
		if(chatRequest.getClientId() != null) {
			Client client = new Client();
			client.setId(chatRequest.getClientId());
			chat.setClient(client);
		}
		
		else {
			chat.setClient(null);
		}
		
		
		return this.daoChat.save(chat);
	}
	
	//----------Delete----------
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		try {
			this.daoChat.findById(id).orElseThrow(ChatNotFoundException::new);
			
			this.daoChat.deleteById(id);
			
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	
	}
	
	
	
}
