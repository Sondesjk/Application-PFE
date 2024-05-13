package tn.projetdemo.demo.services;

import tn.projetdemo.demo.entities.Post;
import tn.projetdemo.demo.entities.QR;

import java.util.List;

public interface QRServiceInter {


	QR createQR(Long userId, Long voitureId, QR qr);
}
