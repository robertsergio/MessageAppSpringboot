package org.message.repo;

import java.util.List;

import org.message.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface UserRepo extends JpaRepository<User, Integer>{

	List<User> findAll();
	User findById(int id);
	User findByName(String name);
	User save(User user);
    void delete(User user);
}
