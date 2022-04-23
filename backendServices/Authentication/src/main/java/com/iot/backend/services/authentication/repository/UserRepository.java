package com.iot.backend.services.authentication.repository;

import com.iot.backend.services.authentication.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findAppUserByEmail(String email);
}
