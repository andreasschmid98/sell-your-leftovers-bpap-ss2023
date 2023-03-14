package de.hsaugsburg.bpap.ss23.sellyourleftovers.repository;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}
