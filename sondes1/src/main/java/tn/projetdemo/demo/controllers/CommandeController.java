package tn.projetdemo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.projetdemo.demo.entities.Commande;
import tn.projetdemo.demo.entities.Voiture;
import tn.projetdemo.demo.services.CommandeServiceInter;

import java.util.List;

@RestController // Ajout de l'annotation
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    private CommandeServiceInter commandeService;

    @PostMapping("/addcommande")
    public ResponseEntity<Commande> addCommande(@RequestBody Commande commande) {
        Commande addedCommande = commandeService.addCommande(commande);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCommande);
    }
    @DeleteMapping(value="/deletecommande/{id}")
    public void deletecommande(@PathVariable Long id)
    {
        commandeService.deleteCommande(id);
    }


    @GetMapping("/getAllcommandes")
    public List<Commande> getAllCommande() {
        return commandeService.getAllCommandes();

    }


}
