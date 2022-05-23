package io.github.diegoss.workshopmongo.config;

import io.github.diegoss.workshopmongo.domain.Post;
import io.github.diegoss.workshopmongo.domain.User;
import io.github.diegoss.workshopmongo.dto.AuthorDTO;
import io.github.diegoss.workshopmongo.repository.PostRepository;
import io.github.diegoss.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = Post.builder()
                .id(null).date(new Date())
                .title("Spring Boot x ASP Net Core")
                .body("haduhsudahudiaidahuidaadasdsiudad")
                .author(new AuthorDTO(maria)).build();

        Post post2 = Post.builder()
                .id(null).date(new Date())
                .title("Let's go travel!")
                .body("Right now man!")
                .author(new AuthorDTO(alex)).build();

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
