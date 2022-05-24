package io.github.diegoss.workshopmongo.repository;

import io.github.diegoss.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String pattern);

    //alternativo ao primeiro
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitle(String pattern);

}
