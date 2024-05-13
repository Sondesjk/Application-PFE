package tn.projetdemo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.projetdemo.demo.entities.Post;
import tn.projetdemo.demo.entities.Role;
import tn.projetdemo.demo.services.PostServiceInter;
import tn.projetdemo.demo.services.RoleServiceImpl;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostServiceInter postServiceInter;
	@PostMapping("add/{userId}")
	public Post createPost(@PathVariable Long userId,@RequestBody Post post)
	{
		return postServiceInter.createPost(userId,post);
	}


	@GetMapping("/all")
	public List<Post> getAllPosts()
	{
return postServiceInter.getAllPosts();
	}

	@GetMapping("get/{postId}")
	public Post getPostById(@PathVariable Long postId)
	{
		return postServiceInter.getPostById(postId);
	}


	@PutMapping("/update/{postId}")
	public Post updatePost (@PathVariable Long postId ,@RequestBody Post updatedPost)
	{
		return postServiceInter.updatePost(postId,updatedPost);
	}

	@GetMapping("/user/{userId}")
	public List<Post> getPsotsByUserId(@PathVariable Long userId)
	{
		return postServiceInter.getPostsByUserId(userId);
	}

}
