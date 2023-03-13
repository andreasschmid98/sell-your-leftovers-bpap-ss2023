package de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}