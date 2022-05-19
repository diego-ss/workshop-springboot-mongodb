package io.github.diegoss.workshopmongo.resources;

import io.github.diegoss.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> listUsers(){
        User user = new User("1", "Diego", "diego@email.com");
        User user2 = new User("2", "Karina", "karina@email.com");
        var list = Arrays.asList(user, user2);
        return ResponseEntity.ok().body(list);
    }
}
