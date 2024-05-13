package tn.projetdemo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.projetdemo.demo.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
