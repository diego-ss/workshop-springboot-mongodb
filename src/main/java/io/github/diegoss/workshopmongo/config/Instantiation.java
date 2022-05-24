package io.github.diegoss.workshopmongo.config;

import io.github.diegoss.workshopmongo.domain.Post;
import io.github.diegoss.workshopmongo.domain.User;
import io.github.diegoss.workshopmongo.dto.AuthorDTO;
import io.github.diegoss.workshopmongo.dto.CommentDTO;
import io.github.diegoss.workshopmongo.repository.PostRepository;
import io.github.diegoss.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
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
                .id(null).date(new Date()).title("Spring Boot x ASP Net Core")
                .body("haduhsudahudiaidahuidaadasdsiudad").author(new AuthorDTO(maria))
                .commments(new ArrayList<>())
                .build();

        Post post2 = Post.builder()
                .id(null).date(new Date()).title("Let's go travel!")
                .body("Right now man!").author(new AuthorDTO(alex))
                .commments(new ArrayList<>())
                .build();

        Post post3 = Post.builder()
                .id(null).date(new Date()).title("UHUUUUUUUUUUUUUUL!")
                .body("SÃO 3 MESES DE FÉRIAS!").author(new AuthorDTO(alex))
                .commments(new ArrayList<>())
                .build();

        post1.getCommments().add(
                CommentDTO.builder()
                        .text("ASP NET CORE FOREVER!").authorDTO(new AuthorDTO(alex))
                        .date(new Date()).build());

        post1.getCommments().add(
                CommentDTO.builder()
                        .text("SPRING BOOT OWN!").authorDTO(new AuthorDTO(bob))
                        .date(new Date()).build());

        post2.getCommments().add(
                CommentDTO.builder()
                        .text("What country do you want to visit?").authorDTO(new AuthorDTO(maria))
                        .date(new Date()).build());

        post3.getCommments().add(
                CommentDTO.builder()
                        .text("FÉRIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAS").authorDTO(new AuthorDTO(bob))
                        .date(new Date()).build());

        postRepository.saveAll(Arrays.asList(post1, post2, post3));

        maria.getPosts().add(post1);
        alex.getPosts().addAll(Arrays.asList(post2, post3));
        userRepository.saveAll(Arrays.asList(maria, alex));

    }
}
