package tn.projetdemo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.projetdemo.demo.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
