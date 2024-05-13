package tn.projetdemo.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	private String body;
	private String imageURL;
	private String title;

	@Temporal(TemporalType.DATE)
	private Date created;


	@JsonIgnore // Add this annotation to avoid infinite recursion during serialization

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;

	@JsonIgnore
	@OneToMany(mappedBy = "post",cascade  =CascadeType.ALL)
	private Set<Comment> comments = new HashSet<>();

}
