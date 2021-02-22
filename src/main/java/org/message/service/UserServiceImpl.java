package org.message.service;

import java.util.List;

import org.message.model.Person;
import org.message.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo repo;
	
	@Override
	public Person add(Person user) {
		return repo.save(user);
	}

	@Override
	public List<Person> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Person get(int id) {
		return repo.findById(id);
	}

	@Override
	public Person edit(Person user) {
		return repo.save(user);
	}

	@Override
	public Person delete(int id) {
		Person user = this.get(id);
        if(user != null){
          repo.delete(user);  
        }
        return user;
	}

	@Override
	public Person getByName(String name) {
		return repo.findByName(name);
	}

}
