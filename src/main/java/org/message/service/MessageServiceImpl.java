package org.message.service;

import java.util.Date;
import java.util.List;

import org.message.model.Message;
import org.message.model.User;
import org.message.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageRepo repo;
	
	@Override
	public List<Message> list(User user) {
		return repo.findByReceiverUserId(user.getUserId());
	}

	@Override
	public Message add(Message message) {
		return repo.save(message);
	}

	@Override
	public Message edit(Message message) {
		return repo.save(message);
	}

	@Override
	public Message get(int id) {
		return repo.findById(id);
		
	}

}
