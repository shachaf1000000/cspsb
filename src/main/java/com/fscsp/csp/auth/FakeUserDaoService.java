package com.fscsp.csp.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.fscsp.csp.config.UserRole.*;
@Repository("fake")
public class FakeUserDaoService implements UserDao{
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public FakeUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<AppUser> selectUserByUsername(String username) {
        return getUsers().stream().filter(AppUser ->username.equals(AppUser.getUsername())).findFirst();
    }
    private List<AppUser>getUsers(){
        List<AppUser> appUsers = Lists.newArrayList(
            new AppUser("admin@gmail.com",passwordEncoder.encode("password"),ADMIN.getGrantedAuthorities(),
                    true,true,true,true),
                new AppUser("company@gmail.com",passwordEncoder.encode("password"),COMPANY.getGrantedAuthorities(),
                        true,true,true,true),
                new AppUser("customer@gmail.com",passwordEncoder.encode("password"),CUSTOMER.getGrantedAuthorities(),
                        true,true,true,true)
        );
        return appUsers;
    }
}
