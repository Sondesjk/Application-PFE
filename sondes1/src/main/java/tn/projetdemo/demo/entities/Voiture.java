package tn.projetdemo.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Voiture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
private Long id;
private String marque;
	private String modele;
private int annee;
private int prix;
private String matricule;
private String numDeChoussi;






@JsonIgnore
	@OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL)
	private List<Image> images;



	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="commande")
	private Commande commande;
}
