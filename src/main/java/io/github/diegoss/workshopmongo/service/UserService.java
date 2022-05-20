package io.github.diegoss.workshopmongo.service;

import io.github.diegoss.workshopmongo.domain.User;
import io.github.diegoss.workshopmongo.dto.UserDTO;
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

    public User insert(User obj){
        return userRepository.insert(obj);
    }

    public void delete(String id){
        userRepository.deleteById(id);
    }

    public User fromDTO(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        return user;
    }
}
