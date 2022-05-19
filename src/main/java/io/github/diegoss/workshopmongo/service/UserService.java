package io.github.diegoss.workshopmongo.service;

import io.github.diegoss.workshopmongo.domain.User;
import io.github.diegoss.workshopmongo.repository.UserRepository;
import io.github.diegoss.workshopmongo.service.exception.ObjectNotFoundException;
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

    public User findById(String id){
        return userRepository.findById(id)
                .orElseThrow(()->new ObjectNotFoundException("Usuário com id " + id + " não encontrado"));
    }
}
