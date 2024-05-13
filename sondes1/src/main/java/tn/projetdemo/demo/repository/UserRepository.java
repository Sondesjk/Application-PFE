package tn.projetdemo.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.projetdemo.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByUsername(String username);
	
	User findByUsername(String username);
	
	@Query(value = "select * from user u where u.username like :cle%", nativeQuery = true)
	List<User> getUsersSWSUN(@Param("cle") String ch);

    User getUserById(Long userId);

    Optional<User> findFirstByUsername(String username);
}
