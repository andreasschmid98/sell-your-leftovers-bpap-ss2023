package de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}