package org.message.service;

import java.util.List;

import org.message.model.Message;
import org.message.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageService {

	List<Message> list(Person user);
	Message add(Message message);
	Message edit(Message message);
	Message get(int id);
	//Message delete(int id);
}
