package tn.projetdemo.demo.services;

import tn.projetdemo.demo.entities.Comment;
import tn.projetdemo.demo.entities.Post;
import tn.projetdemo.demo.entities.Voiture;

import java.util.List;

public interface VoitureServiceInter {


    Voiture addVoiture(Voiture voiture);

    void deleteVoiture(Long id);

    Voiture updateVoiture(Long id, Voiture voiture);

    Voiture getVoitureById(Long id);
    List<Voiture> getAllVoitures();

    List<Voiture> findByMarque(String marque);
    List<Voiture> findByModele(String modele);

}