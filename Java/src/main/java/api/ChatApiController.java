package api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import dao.IDAOChat;
import model.Chat;


@RestController
@RequestMapping("/api/chat")
public class ChatApiController {
	
	@Autowired
	private IDAOChat daoChat;
	
	@GetMapping
	@JsonView(Views.Chat.class)
	public List<Chat> findAll() {
		return this.daoChat.findAll();
	}

}
