package tn.projetdemo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.projetdemo.demo.entities.Comment;
import tn.projetdemo.demo.entities.QR;
import tn.projetdemo.demo.services.CommentServiceInter;
import tn.projetdemo.demo.services.QRServiceInter;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping("/QR")
public class QRController {

	@Autowired
	private QRServiceInter qrServiceInter;


	@PostMapping("/add/user/{userId}/voiture/{voitureId}")
	public QR createQR (@PathVariable Long userId,@PathVariable Long voitureId, @RequestBody QR qr){
		return qrServiceInter.createQR(userId,voitureId,qr);
	}






}
