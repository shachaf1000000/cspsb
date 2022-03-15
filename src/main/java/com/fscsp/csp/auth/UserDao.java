package com.fscsp.csp.auth;

import java.util.Optional;

public interface UserDao {
    Optional<AppUser> selectUserByUsername(String username);
}
