package com.fscsp.csp.config;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.fscsp.csp.config.UserPermissions.*;

public enum UserRole {
    ADMIN(Sets.newHashSet(COMPANY_READ,COMPANY_WRITE,COUPON_READ,COUPON_WRITE,CUSTOMER_READ,CUSTOMER_WRITE)),
    COMPANY(Sets.newHashSet(COUPON_READ,COUPON_WRITE)),
    CUSTOMER(Sets.newHashSet(COUPON_READ));

    private final Set<UserPermissions> permissions;

    UserRole(Set<UserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermissions> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority>getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;
    }
}
