package org.message.service;

import java.util.List;

import org.message.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {

	List<Person> list();
	Person get(int id);
	Person getByName(String name);
	Person add(Person user);
	Person edit(Person user);
	Person delete(int id);
}
