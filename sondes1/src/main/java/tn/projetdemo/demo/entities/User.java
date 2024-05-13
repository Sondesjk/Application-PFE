package tn.projetdemo.demo.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private  String firstname;
	private String lastname;
	private String email;
	private String username;
	private String password;
	private String confpassword;
	private String address;


	@ManyToMany
	@JoinTable(name="userrole",joinColumns = @JoinColumn(name="id"), inverseJoinColumns = @JoinColumn(name="idrole"))
@JsonIgnore
	private Set<Role> role  = new HashSet<>();


	@JsonIgnore

	@OneToMany(mappedBy ="user",cascade = CascadeType.ALL)
private Set<Post> posts= new HashSet<>();


	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Voiture> voitures = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Commande> commandes = new HashSet<>();


}
