package tn.projetdemo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.projetdemo.demo.entities.Comment;
import tn.projetdemo.demo.entities.QR;

@Repository
public interface QRRepository extends JpaRepository<QR, Long> {

}
