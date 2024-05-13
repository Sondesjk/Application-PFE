package tn.projetdemo.demo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import tn.projetdemo.demo.entities.User;
import tn.projetdemo.demo.entities.Voiture;

public interface UserServiceInter {

	public User addUser(User user);
	public List<User> addListUser(List<User> listuser);
	
	public String addUserWTCP(User user);
	public String addUserWTUN(User user);
	
	public User updateUser(Long iduser, User user);
	public void deleteUser(Long iduser);
	
	public List<User> getListUsers();

    User getUserById(Long id);

    public User getByUsername(String username);
	
	public List<User> getUsersSWSUN(String ch);

	ResponseEntity<User> login(String username, String password);
}
