package tn.projetdemo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.projetdemo.demo.entities.Image;
import tn.projetdemo.demo.entities.Voiture;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long> {





    List<Voiture> findByMarque(String marque);
    List<Voiture> findByModele(String modele);
}