package tn.projetdemo.demo.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.projetdemo.demo.entities.Role;
import tn.projetdemo.demo.entities.User;
import tn.projetdemo.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServiceInter {

	@Autowired
	UserRepository userRep;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		Role defaultRole = new Role();
		defaultRole.setIdrole(1L);

		Set<Role> roles = new HashSet<>();
		roles.add(defaultRole);
		user.setRole(roles);
		
		return userRep.save(user);
		
	}


	@Override
	public List<User> addListUser(List<User> listuser) {
		// TODO Auto-generated method stub
		return userRep.saveAll(listuser);
	}


	@Override
	public String addUserWTCP(User user) {
		// TODO Auto-generated method stub
		
		String ch="";
		
		if(user.getPassword().equals(user.getConfpassword()))
		{
			userRep.save(user);
			ch="user added successfuly !!";
		}
		else
		{
			ch="check confirm password !!!";
		}
		
		return ch;
	}


	@Override
	public String addUserWTUN(User user) {
		// TODO Auto-generated method stub
		String ch="";
		if(userRep.existsByUsername(user.getUsername())) {
		
			ch="username already exists";
		}
		else {
			
			userRep.save(user);
			ch="user added successfully !!!";
		}
		
		return ch;
	}


	@Override
	public User updateUser(Long iduser, User user) {
		// TODO Auto-generated method stub
		
		User usr = userRep.findById(iduser).get();
		
		usr.setFirstname(user.getFirstname());
		usr.setLastname(user.getLastname());
		
		return userRep.save(usr);
	}


	@Override
	public void deleteUser(Long iduser) {
		// TODO Auto-generated method stub
		userRep.deleteById(iduser);
	}


	@Override
	public List<User> getListUsers() {
		// TODO Auto-generated method stub
		return userRep.findAll();
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			throw new IllegalArgumentException("User not found with id: " + id);
		}
	}


	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return userRep.findByUsername(username);
	}


	@Override
	public List<User> getUsersSWSUN(String ch) {
		// TODO Auto-generated method stub
		return userRep.getUsersSWSUN(ch);
	}
	@Override
	public ResponseEntity<User> login(String username, String password) {
		Optional<User> optionalUser = userRep.findFirstByUsername(username);

		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			if (user.getPassword().equals(password)) {
				return ResponseEntity.ok(user);
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		} else {
			// Aucun utilisateur avec ce nom d'utilisateur n'a été trouvé
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}


}
