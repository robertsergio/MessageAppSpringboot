package org.message.repo;

import java.util.List;

import org.message.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface UserRepo extends JpaRepository<Person, Integer>{

	List<Person> findAll();
	Person findById(int id);
	Person findByName(String name);
	Person save(Person user);
    void delete(Person user);
}
