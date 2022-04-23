package com.iot.backend.services.authentication.service;

import com.iot.backend.services.authentication.model.AppUser;
import com.iot.backend.services.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    @Autowired
    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public AppUser saveUser(AppUser user) {
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
}
