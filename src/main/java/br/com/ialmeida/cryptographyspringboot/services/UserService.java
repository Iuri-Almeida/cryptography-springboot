package br.com.ialmeida.cryptographyspringboot.services;

import br.com.ialmeida.cryptographyspringboot.entities.User;
import br.com.ialmeida.cryptographyspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Id " + id + " not found."));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

}
