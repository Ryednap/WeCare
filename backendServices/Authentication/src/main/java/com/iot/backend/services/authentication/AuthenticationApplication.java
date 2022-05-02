package com.iot.backend.services.authentication;

import com.iot.backend.services.authentication.model.AppUser;
import com.iot.backend.services.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

@SpringBootApplication
public class AuthenticationApplication {
    public static void main (String [] args) {
        SpringApplication.run(AuthenticationApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        int encoderStrength = 10;
        return new BCryptPasswordEncoder(encoderStrength, new SecureRandom());
    }

}
