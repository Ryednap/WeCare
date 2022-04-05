package com.iot.backend.services.authentication.service;

import com.iot.backend.services.authentication.model.AppUser;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    AppUser getUser(String email);
    List<AppUser> getUsers();
}
