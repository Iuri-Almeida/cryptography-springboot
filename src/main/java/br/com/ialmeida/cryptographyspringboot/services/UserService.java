package br.com.ialmeida.cryptographyspringboot.services;

import br.com.ialmeida.cryptographyspringboot.entities.User;
import br.com.ialmeida.cryptographyspringboot.repositories.UserRepository;
import br.com.ialmeida.cryptographyspringboot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User findByName(String name) {
        Optional<User> user = userRepository.findByName(name);
        return user.isEmpty() ? null : user.get();
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id, User user) {
        User entity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Id " + id + " not found."));
        updateData(entity, user);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
    }

}
