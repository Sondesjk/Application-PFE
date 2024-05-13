package tn.projetdemo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.projetdemo.demo.entities.Post;
import tn.projetdemo.demo.entities.Role;
import tn.projetdemo.demo.entities.User;
import tn.projetdemo.demo.entities.Voiture;
import tn.projetdemo.demo.repository.PostRepository;
import tn.projetdemo.demo.repository.UserRepository;
import tn.projetdemo.demo.repository.VoitureRepository;

import java.util.*;

@Service
public class VoitureServiceImpl implements VoitureServiceInter {

	@Autowired
	private VoitureRepository voitureRepository;

	@Override
	public Voiture addVoiture(Voiture voiture) {
		return voitureRepository.save(voiture);
	}

	@Override
	public void deleteVoiture(Long id) {
		voitureRepository.deleteById(id);
	}

	@Override
	public Voiture updateVoiture(Long id, Voiture newVoiture) {
		Optional<Voiture> optionalVoiture = voitureRepository.findById(id);
		if (optionalVoiture.isPresent()) {
			Voiture existingVoiture = optionalVoiture.get();
			existingVoiture.setMarque(newVoiture.getMarque());
			existingVoiture.setAnnee(newVoiture.getAnnee());
			existingVoiture.setPrix(newVoiture.getPrix());
			existingVoiture.setMatricule(newVoiture.getMatricule());
			existingVoiture.setNumDeChoussi(newVoiture.getNumDeChoussi());
			return voitureRepository.save(existingVoiture);
		} else {
			throw new IllegalArgumentException("Voiture not found with id: " + id);
		}
	}

	@Override
	public Voiture getVoitureById(Long id) {
		Optional<Voiture> optionalVoiture = voitureRepository.findById(id);
		if (optionalVoiture.isPresent()) {
			return optionalVoiture.get();
		} else {
			throw new IllegalArgumentException("Voiture not found with id: " + id);
		}
	}
	//recherche
	@Override
	public List<Voiture> findByMarque(String marque) {
		return voitureRepository.findByMarque(marque);
	}

	@Override
	public List<Voiture> findByModele(String modele) {
		return voitureRepository.findByModele(modele);
	}

	@Override
	public List<Voiture> getAllVoitures() {
		return voitureRepository.findAll();
	}

}