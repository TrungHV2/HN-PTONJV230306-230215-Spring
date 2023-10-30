package com.ra.model;

import com.ra.model.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsAdapter implements UserDetails {
    private String username;
    private String password;
    private String roles;

    public UserDetailsAdapter(UserEntity user) {
        this.username = user.getUsername();
        this.password = "$2a$12$QPNogVbEmfTbDFNTz6eSc.ngjWiklgh7DZROT8HAO1l5aEH.WZgLe";
        this.roles = "ROLE_ADMIN,ROLE_CUSTOMER";
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        if (this.roles != null) {
            String[] _roles = this.roles.split(",");
            for (String role : _roles) {
                roles.add(new SimpleGrantedAuthority(role));
            }
        }
        return roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
