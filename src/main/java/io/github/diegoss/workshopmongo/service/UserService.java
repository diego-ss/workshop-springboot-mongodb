package io.github.diegoss.workshopmongo.service;

import io.github.diegoss.workshopmongo.domain.User;
import io.github.diegoss.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAll(){
        return userRepository.findAll();
    }
}
