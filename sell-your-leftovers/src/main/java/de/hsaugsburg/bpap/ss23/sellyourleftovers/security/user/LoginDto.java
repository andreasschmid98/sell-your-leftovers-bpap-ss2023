package de.hsaugsburg.bpap.ss23.sellyourleftovers.security.user;

import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String password;
}