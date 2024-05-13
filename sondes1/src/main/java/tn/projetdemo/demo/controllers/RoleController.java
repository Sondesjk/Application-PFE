package tn.projetdemo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.projetdemo.demo.entities.Role;
import tn.projetdemo.demo.services.RoleServiceImpl;
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
public class RoleController {

	@Autowired
	RoleServiceImpl roleServ;
	
	@PostMapping(value = "/addRole")
	public Role addRole(@RequestBody Role role) {
		
		return roleServ.addRole(role);
		
	}
}
