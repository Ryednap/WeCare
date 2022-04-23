package com.iot.backend.services.authentication.service;

import com.iot.backend.services.authentication.model.AppUser;
import com.iot.backend.services.authentication.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.passwordEncoder = encoder;
    }

    @Override
    public AppUser saveUser(AppUser user) {
        log.debug("Saving User: {}", user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.debug("Encoded user Password: {}", user.getPassword());
        return repo.save(user);
    }

    @Override
    public AppUser getUser(String email) {
        return repo.findAppUserByEmail(email);
    }

    @Override
    public List<AppUser> getUsers() {
        return repo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user = repo.findAppUserByEmail(email);
        log.debug("loadUserByUsername : found User : {}", user);
        if (user == null) {
            throw new UsernameNotFoundException("User of provided email doesn't exist");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return new User(user.getEmail(), user.getPassword(), authorities);
    }
}
