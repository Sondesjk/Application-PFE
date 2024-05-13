package tn.projetdemo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.projetdemo.demo.entities.Commande;
import tn.projetdemo.demo.entities.Voiture;
import tn.projetdemo.demo.repository.CommandeRepository;

import java.util.List;

@Service
public class CommandeServiceImp implements CommandeServiceInter{


    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }


    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public void deleteCommande(Long idcommande) {
        // TODO Auto-generated method stub
        commandeRepository.deleteById(idcommande);
    }
}
