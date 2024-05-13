package tn.projetdemo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.projetdemo.demo.entities.Post;
import tn.projetdemo.demo.entities.User;
import tn.projetdemo.demo.entities.Voiture;
import tn.projetdemo.demo.services.UserServiceImpl;
import tn.projetdemo.demo.services.VoitureServiceInter;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RequestMapping("/voiture")

public class VoitureController {



    @Autowired
    private VoitureServiceInter voitureService;


    @PostMapping("/add")
    public ResponseEntity<Voiture> addVoiture(@RequestBody Voiture voiture) {
        Voiture addedVoiture = voitureService.addVoiture(voiture);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedVoiture);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVoiture(@PathVariable Long id) {
        voitureService.deleteVoiture(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Voiture> updateVoiture(@PathVariable Long id, @RequestBody Voiture voiture) {
        Voiture updatedVoiture = voitureService.updateVoiture(id, voiture);
        return ResponseEntity.ok(updatedVoiture);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Voiture> getVoitureById(@PathVariable Long id) {
        Voiture voiture = voitureService.getVoitureById(id);
        return ResponseEntity.ok(voiture);
    }
    @GetMapping("/getAllvoitures")
    public List<Voiture> getAllVoitures() {
       return voitureService.getAllVoitures();

    }



    @GetMapping("/recherche/{marque}")
    public List<Voiture> getVoituresByModele(@PathVariable String marque) {
        return voitureService.findByMarque(marque);
    }
}


