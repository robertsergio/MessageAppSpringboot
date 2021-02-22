package org.message.service;

import java.util.List;

import org.message.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {

	List<User> list();
	User get(int id);
	User getByName(String name);
	User add(User user);
	User edit(User user);
	User delete(int id);
}
