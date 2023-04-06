package formationsopra.catCafe.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
//import org.apache.commons.io.FileUtils;

import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.parser.MediaType;
import org.apache.tomcat.util.http.parser.MediaTypeCache;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formationsopra.catCafe.dao.IDAOChat;
import formationsopra.catCafe.exception.ChatBadRequestException;
import formationsopra.catCafe.exception.ChatNotFoundException;
import formationsopra.catCafe.model.Chat;
import formationsopra.catCafe.model.Client;
import formationsopra.catCafe.request.ChatRequest;
import jakarta.validation.Valid;

import org.springframework.web.multipart.MultipartFile;
import formationsopra.catCafe.utils.saveImage;
import io.micrometer.common.util.StringUtils;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin("*")
public class ChatApiController {

	@Autowired
	private IDAOChat daoChat;
    	//private String imageLocation = "../../../assets/img/api/chat";
    	//private String imageFrontLocation = "../../../assets/img/api/chat/";
    	private String imageLocation = "C:/Users/jorda/assets/img/api/chat";
    	private String imageFrontLocation = "C:/Users/jorda/assets/img/api/chat/";



	// ----------FindAll----------
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

	// ----------FindById----------
	@GetMapping("/{id}")
	@JsonView(Views.Chat.class)
	public Chat findById(@PathVariable int id) {
		return this.daoChat.findById(id).orElseThrow(ChatNotFoundException::new);

	}

	//
	@GetMapping("/by-client-id/{clientId}")
	@JsonView(Views.Chat.class)
	public List<Chat> findAllByClientId(@PathVariable int clientId) {
		return this.daoChat.findAllByClientId(clientId);
	}

	// ----------ADD----------
	@PostMapping
	@JsonView(Views.Chat.class)
	public Chat add(@RequestBody @Valid ChatRequest chatRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new ChatBadRequestException();
		}

		Chat chat = new Chat();
		BeanUtils.copyProperties(chatRequest, chat);
		if (chatRequest.getClientId() != null) {
			Client client = new Client();
			client.setId(chatRequest.getClientId());
			chat.setClient(client);
		}

		else {
			chat.setClient(null);
		}

		return this.daoChat.save(chat);

	}

	// ----------EDIT----------
	@PutMapping("/{id}")
	@JsonView(Views.Chat.class)
	public Chat edit(@PathVariable int id, @RequestBody @Valid ChatRequest chatRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new ChatBadRequestException();
		}

		Chat chat = this.daoChat.findById(id).orElseThrow(ChatNotFoundException::new);

		BeanUtils.copyProperties(chatRequest, chat);
		System.out.println(chatRequest.getClientId());

		if (chatRequest.getClientId() != null) {
			Client client = new Client();
			client.setId(chatRequest.getClientId());
			chat.setClient(client);
		}

		else {
			chat.setClient(null);
		}

		return this.daoChat.save(chat);
	}

	// ----------Delete----------
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

	// Add Image

	@PutMapping("/image/{id}")
	@JsonView(Views.Compte.class)
	public Chat editImage(@PathVariable int id, @RequestParam("file") MultipartFile multipartFile) throws IOException {

		String fileName = multipartFile.getOriginalFilename();
		String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
		saveImage.saveFile(imageLocation, (id+"."+extension), multipartFile);

		Chat c = this.daoChat.findById(id).orElseThrow(ChatNotFoundException::new);
		c.setImage(imageFrontLocation + id +"."+ extension);

		return this.daoChat.save(c);
	}

	// return image Dont work for now

	/*@GetMapping("/image")
	public @ResponseBody byte[] getImage() throws IOException {


		/*InputStream in = getClass().getResourceAsStream(imageLocation+"1.png");	

		return IOUtils.toByteArray(in);/
		//Pat file = root.resolve(filename);
		//Resource resource = new UrlResource(file.toUri());
		//File outputfile = new File(imageLocation+"1.png");


        //try {
		//	InputStreamResource resource = new InputStreamResource(new FileInputStream(outputfile));


       // } catch (IOException e) {
         //   e.printStackTrace();
       // }
	//return resource;
	}*/

	/*@ResponseBody
	@RequestMapping(value = "/photo2", method = RequestMethod.GET, produces = MediaTypeCache.IMAGE_JPEG_VALUE)
	public byte[] testphoto() throws IOException {
		InputStream in = servletContext.getResourceAsStream("/images/no_image.jpg");
		return IOUtils.toByteArray(in);
	}*/
}
