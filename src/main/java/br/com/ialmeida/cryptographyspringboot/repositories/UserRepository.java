package br.com.ialmeida.cryptographyspringboot.repositories;

import br.com.ialmeida.cryptographyspringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
