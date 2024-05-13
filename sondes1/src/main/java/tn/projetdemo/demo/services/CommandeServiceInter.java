package tn.projetdemo.demo.services;

import tn.projetdemo.demo.entities.Commande;
import tn.projetdemo.demo.entities.Voiture;

import java.util.List;


public interface CommandeServiceInter {
    Commande addCommande(Commande commande);
    List<Commande> getAllCommandes();
    public void deleteCommande(Long idcommande);
}
