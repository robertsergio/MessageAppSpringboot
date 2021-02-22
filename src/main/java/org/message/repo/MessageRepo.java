package org.message.repo;

import java.util.List;

import org.message.model.Message;
import org.message.model.User;
import org.springframework.data.repository.Repository;

public interface MessageRepo extends Repository<Message, Integer>{

	List<Message> findAll();
	List<Message> findByReceiverUserId(int userId);
	Message findById(int id);
	Message save(Message m);
    void delete(Message m);

}
