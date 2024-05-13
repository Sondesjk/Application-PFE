package tn.projetdemo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.projetdemo.demo.entities.Post;
import tn.projetdemo.demo.entities.User;
import tn.projetdemo.demo.repository.PostRepository;
import tn.projetdemo.demo.repository.UserRepository;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostServiceInter {


	@Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Post createPost(Long userId, Post post) {
        User user = userRepository.getUserById(userId);
        if(user!=null)
        {
            post.setUser(user);
            post.setCreated(new Date());
            return postRepository.save(post);
        }else{
            throw new IllegalArgumentException("User Not found");
        }
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    @Override
    public Post updatePost(Long postId, Post updatedPost) {
Post existingPost = postRepository.findById(postId).orElse(null);
if(existingPost!=null)
{
    existingPost.setBody(updatedPost.getBody());
    existingPost.setImageURL(updatedPost.getImageURL());
    existingPost.setTitle(updatedPost.getTitle());
    return postRepository.save(existingPost);
}

return null;
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }


}
