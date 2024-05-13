package tn.projetdemo.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class QR {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long idQr;
	private String version;
	private String size;




}
