package tn.projetdemo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.projetdemo.demo.entities.Role;
import tn.projetdemo.demo.repository.RoleRepository;

@Service
public class RoleServiceImpl  implements RoleServiceInter{

	@Autowired
	RoleRepository roleRep;
	
	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return roleRep.save(role);
	}

}
