package de.hsaugsburg.bpap.ss23.sellyourleftovers.mapper;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request.RegisterRequest;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

public class UserMapper {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static User map(RegisterRequest registerRequest) {
        return User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .orders(new ArrayList<>())
                .build();
    }
}
