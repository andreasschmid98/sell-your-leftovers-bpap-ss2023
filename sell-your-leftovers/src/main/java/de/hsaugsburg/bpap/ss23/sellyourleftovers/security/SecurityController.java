package de.hsaugsburg.bpap.ss23.sellyourleftovers.security;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.security.user.LoginDto;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.security.user.RegisterDto;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.security.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class SecurityController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto, authenticationManager);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto){
        return userService.register(registerDto);
    }



}

