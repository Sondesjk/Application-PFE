package tn.projetdemo.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class AnnonceVoiture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
private String description;
private String titre;




}
