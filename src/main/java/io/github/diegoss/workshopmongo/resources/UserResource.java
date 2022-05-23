package io.github.diegoss.workshopmongo.resources;

import io.github.diegoss.workshopmongo.domain.Post;
import io.github.diegoss.workshopmongo.domain.User;
import io.github.diegoss.workshopmongo.dto.UserDTO;
import io.github.diegoss.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        var list = userService.listAll();
        var dtoList = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        var user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> listPosts(@PathVariable String id){
        var user = userService.findById(id);
        return ResponseEntity.ok().body(user.getPosts());
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO obj){
        User user = userService.fromDTO(obj);
        user = userService.insert(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody UserDTO obj, @PathVariable String id){
        User user = userService.fromDTO(obj);
        user.setId(id);
        user = userService.update(user);
        return ResponseEntity.noContent().build();
    }
}
