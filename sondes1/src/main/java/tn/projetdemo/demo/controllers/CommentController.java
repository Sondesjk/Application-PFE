package tn.projetdemo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.projetdemo.demo.entities.Comment;
import tn.projetdemo.demo.entities.Post;
import tn.projetdemo.demo.services.CommentServiceInter;
import tn.projetdemo.demo.services.PostServiceInter;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	private CommentServiceInter commentServiceInter;

	@PostMapping("/add/user/{userId}/post/{postId}")
	public Comment createComment(@PathVariable Long userId,
								 @PathVariable Long postId,
								 @RequestBody Comment comment){

		return commentServiceInter.createComment(userId,postId,comment);
	}

	@GetMapping("/all")
	public List<Comment>getAllComments()
	{
		return commentServiceInter.getAllComments();
	}




}
