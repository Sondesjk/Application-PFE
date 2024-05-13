package tn.projetdemo.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.projetdemo.demo.entities.User;
import tn.projetdemo.demo.services.UserServiceImpl;

@RestController


@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UserController {

	@Autowired
	UserServiceImpl userServ;
	
	@PostMapping(value = "/add")
	public User addUser(@RequestBody User user)
	{
		return userServ.addUser(user);
	}
	
	@PostMapping(value = "/addListUser")
	public List<User> addListUser(@RequestBody List<User> listuser)
	{
		return userServ.addListUser(listuser);
	}
	@PostMapping(value = "/addUserWTCP")
	public String addUserWTCP(@RequestBody User user)
	{
		return userServ.addUserWTCP(user);
	}
	@PostMapping(value = "/addUserWTEUN")
	public String addUserWTEUN(@RequestBody User user)
	{
		return userServ.addUserWTUN(user);
	}
	
	@PutMapping (value = "/updateUser/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user)
	{
		return userServ.updateUser(id, user);
	}
	
	@DeleteMapping(value="/deleteuser/{id}")
	public void deleteuser(@PathVariable Long id)
	{
		 userServ.deleteUser(id);
	}
	
	@GetMapping(value="/getAllUsers")
	public List<User> getAllUsers()
	{
		return userServ.getListUsers();
	}


    @GetMapping(value="/getUserById/{id}")
    public User getUserById(@PathVariable long id) {
        return userServ.getUserById(id);}
	@GetMapping(value="/getUserByUN/{un}")
	public User getUserByUN(@PathVariable String un)
	{
		return userServ.getByUsername(un);
	} 
	
	@GetMapping(value="/getUsersSWSUN/{un}")
	public List<User> getUsersSWSUN(@PathVariable String un)
	{
		return userServ.getUsersSWSUN(un);
	}
	@GetMapping("/login")
	public ResponseEntity<User> login(@RequestParam String username, @RequestParam String password) {
		return userServ.login(username,password);
	}
	}



