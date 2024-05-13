package tn.projetdemo.demo.controllers;

import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.projetdemo.demo.entities.*;
import tn.projetdemo.demo.repository.ImageRepository;
import tn.projetdemo.demo.repository.UserRepository;
import tn.projetdemo.demo.repository.VoitureRepository;
import tn.projetdemo.demo.services.CommentServiceInter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping("/image")
public class ImageController {

	@Autowired
	ImageRepository imageRepository;

	@Autowired
	VoitureRepository voitureRepository;

	@PostMapping("/upload/{idVoiture}")
	public ResponseEntity<String> uploadImage(@RequestParam("imageFile") MultipartFile file, @PathVariable Long idVoiture) {
		try {
			Optional<Voiture> voitureOptional = voitureRepository.findById(idVoiture);

			if (voitureOptional.isPresent()) {

				Image img = new Image();
				img.setName(file.getOriginalFilename());
				img.setPicByte(compressBytes(file.getBytes()));
				img.setVoiture(voitureOptional.get());
				imageRepository.save(img);
				return ResponseEntity.ok("Image ( " + img.getName() + " ) added to voiture with ID:" + img.getVoiture().getId());
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/get/{idVoiture}")
	public ResponseEntity<Image> getImageByVoitureId(@PathVariable Long idVoiture) {
		Optional<Image> retrievedImage = imageRepository.findByVoitureId(idVoiture);

		if (retrievedImage.isPresent()) {
			Image img = retrievedImage.get();
			img.setPicByte(decompressBytes(img.getPicByte()));
			return ResponseEntity.ok(img);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/update/{idVoiture}")
	public ResponseEntity<String> updateImage(@RequestParam("imageFile") MultipartFile file, @PathVariable Long idVoiture) {
		try {
			Optional<Voiture> voitureOptional = voitureRepository.findById(idVoiture);
			if (voitureOptional.isPresent()) {
				Voiture voiture = voitureOptional.get();
				Image image = voiture.getImages().stream().findFirst().orElse(null);
				if (image == null) {
					return ResponseEntity.notFound().build();
				}
				image.setName(file.getOriginalFilename());
				image.setPicByte(compressBytes(file.getBytes()));
				imageRepository.save(image);
				return ResponseEntity.ok("Updated");
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@DeleteMapping("/delete/{idVoiture}")
	public ResponseEntity<String> deleteImage(@PathVariable Long idVoiture) {
		Optional<Voiture> voitureOptional = voitureRepository.findById(idVoiture);
		if (voitureOptional.isPresent()) {
			Voiture voiture = voitureOptional.get();
			if (voiture.getImages() != null && !voiture.getImages().isEmpty()) {
				imageRepository.deleteAll(voiture.getImages());
				return ResponseEntity.ok("Images deleted of voiture: " + idVoiture);
			} else {
				return ResponseEntity.notFound().build();
			}
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException | DataFormatException e) {
			e.printStackTrace();
		}
		return outputStream.toByteArray();
	}
}