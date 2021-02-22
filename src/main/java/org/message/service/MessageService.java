package org.message.service;

import java.util.List;

import org.message.model.Message;
import org.message.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageService {

	List<Message> list(User user);
	Message add(Message message);
	Message edit(Message message);
	Message get(int id);
	//Message delete(int id);
}
