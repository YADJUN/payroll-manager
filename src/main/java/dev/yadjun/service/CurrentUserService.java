package dev.yadjun.service;

import dev.yadjun.entity.User;
import dev.yadjun.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrentUserService {
    private final UserRepository userRepository;

    public User getCurrentUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        String username = authentication.getName();
        System.out.println("AUTHENTICATION = " + authentication);
        System.out.println("USERNAME = " + username);

        return userRepository.findByUsername("yadjun").orElseThrow();
    }
}
