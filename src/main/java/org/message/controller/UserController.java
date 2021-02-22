package org.message.controller;

import java.util.List;

import org.message.exception.CustomException;
import org.message.model.User;
import org.message.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "${crossorigin.host}")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/{name}")
	//better if we return a Data Result Object
	public User register(@PathVariable("name") String name) throws CustomException
	{
		try {
			return userService.add(new User(0, name));
		}
		catch(Exception e)
		{
			throw new CustomException(e.getMessage());
		}
		
	}
	
	@GetMapping
	public List<User> list()
	{
		return userService.list();
	}
	
	@GetMapping(path = {"/{id}"})
    public User get(@PathVariable("id") int id){
        return userService.get(id);
    }
    
    @PutMapping(path = {"/{id}"})
    public User edit(@RequestBody User user, @PathVariable("id") int id){
        user.setUserId(id);
        try {
        	return userService.edit(user);
		}
		catch(Exception e)
		{
			throw new CustomException(e.getMessage());
		}
        
    }
    @DeleteMapping(path = {"/{id}"})
    public User delete(@PathVariable("id") int id){
    	try {
    		return this.userService.delete(id);
		}
		catch(Exception e)
		{
			throw new CustomException(e.getMessage());
		}
    }
}
