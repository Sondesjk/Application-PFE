package tn.projetdemo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.projetdemo.demo.entities.Comment;
import tn.projetdemo.demo.entities.Post;
import tn.projetdemo.demo.entities.User;
import tn.projetdemo.demo.repository.CommentRepository;
import tn.projetdemo.demo.repository.PostRepository;
import tn.projetdemo.demo.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentServiceInter {


	@Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;


    @Override
    public Comment createComment(Long userId, Long postId, Comment comment) {
        User user=userRepository.getUserById(userId);
        if(user!=null)
        {
            Optional<Post> optionalPost=postRepository.findById(postId);
            if(optionalPost.isPresent())
            {
                Post post=optionalPost.get();
comment.setPost(post);


comment.setCreated(new Date());

return commentRepository.save(comment);

            }else{
                throw new IllegalArgumentException("ERROR");
            }

        }else{
            throw new IllegalArgumentException("ERROR");
        }
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}
