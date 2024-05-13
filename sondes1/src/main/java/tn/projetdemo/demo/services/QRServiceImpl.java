package tn.projetdemo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.projetdemo.demo.entities.*;
import tn.projetdemo.demo.repository.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class QRServiceImpl implements QRServiceInter {

    @Autowired
    private QRRepository qrRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VoitureRepository voitureRepository;
    @Override
    public QR createQR(Long userId, Long voitureId, QR qr) {
User user =userRepository.getUserById(userId);
if(user!=null)
{
    Optional<Voiture> optionalVoiture= voitureRepository.findById(voitureId);
    if(optionalVoiture.isPresent())
    {
        Voiture voiture = optionalVoiture.get();
    }return qrRepository.save(qr);
}else {
    throw new IllegalArgumentException("voiture nor found");
}
    }
}
