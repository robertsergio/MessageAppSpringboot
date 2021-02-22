package org.message.service;

import java.util.List;

import org.message.model.User;
import org.message.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo repo;
	
	@Override
	public User add(User user) {
		return repo.save(user);
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User get(int id) {
		return repo.findById(id);
	}

	@Override
	public User edit(User user) {
		return repo.save(user);
	}

	@Override
	public User delete(int id) {
		User user = this.get(id);
        if(user != null){
          repo.delete(user);  
        }
        return user;
	}

	@Override
	public User getByName(String name) {
		return repo.findByName(name);
	}

}
