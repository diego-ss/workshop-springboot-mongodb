package io.github.diegoss.workshopmongo.resources;

import io.github.diegoss.workshopmongo.domain.Post;
import io.github.diegoss.workshopmongo.domain.User;
import io.github.diegoss.workshopmongo.dto.UserDTO;
import io.github.diegoss.workshopmongo.service.PostService;
import io.github.diegoss.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        var list = postService.listAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        var obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
