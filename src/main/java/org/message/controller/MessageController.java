package org.message.controller;

import java.util.Date;
import java.util.List;

import org.message.exception.CustomException;
import org.message.model.Message;
import org.message.model.User;
import org.message.service.MessageService;
import org.message.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	//POST
	@PostMapping("/{sender}/{receiver}")
	//better if we return a Data Result Object
	public Message send(@PathVariable("sender") String sender, @PathVariable("receiver") String receiver, String message) throws CustomException
	{
		try {
			User senderUser = userService.getByName(sender);
			User receiverUser = userService.getByName(receiver);
			
			if(senderUser != null && receiverUser != null)
			{
				return messageService.add(new Message(0, message, senderUser, receiverUser, new Date(System.currentTimeMillis()), null));
			}
			throw new CustomException("Sender or Receiver does not exist.");
		}
		catch(Exception e)
		{
			throw new CustomException(e.getMessage());
		}
	}
	
	//@RequestMapping(value = "/{receiver}", method = RequestMethod.GET)
	@GetMapping("/{receiver}")
	public List<Message> messages( @PathVariable("receiver") String receiver) 
	{
		User u = userService.getByName(receiver);
		
		if(u != null)
		{
			return messageService.list(u);
		}
		throw new CustomException("User does not exist.");
	}
	
	//@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@GetMapping("/view/{id}")
	public Message show( @PathVariable("id") int id) 
	{
		Message m = messageService.get(id);
		
		if(m.getSeen() == null)
		{
			m.setSeen(new Date(System.currentTimeMillis()));
		}
		return messageService.edit(m);
	}
}
