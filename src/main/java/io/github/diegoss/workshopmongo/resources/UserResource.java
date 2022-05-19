package io.github.diegoss.workshopmongo.resources;

import io.github.diegoss.workshopmongo.domain.User;
import io.github.diegoss.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> listUsers(){
        var list = userService.listAll();
        return ResponseEntity.ok().body(list);
    }
}
