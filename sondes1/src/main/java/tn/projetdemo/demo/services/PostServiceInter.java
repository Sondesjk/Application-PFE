package tn.projetdemo.demo.services;

import tn.projetdemo.demo.entities.Post;
import tn.projetdemo.demo.entities.User;

import java.util.List;

public interface PostServiceInter {


	Post createPost(Long userId, Post post);


	List<Post> getAllPosts();

	Post getPostById(Long postId);

	Post updatePost(Long postId, Post updatedPost);

    List<Post> getPostsByUserId(Long userId);
}
