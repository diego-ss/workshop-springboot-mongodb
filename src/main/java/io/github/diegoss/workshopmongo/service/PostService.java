package io.github.diegoss.workshopmongo.service;

import io.github.diegoss.workshopmongo.domain.Post;
import io.github.diegoss.workshopmongo.repository.PostRepository;
import io.github.diegoss.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> listAll(){
        return postRepository.findAll();
    }

}
