package com.foroHub.api.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface Usuarioo {
    Collection<? extends GrantedAuthority> getAuthorities();

    String getPassword();

    String getUsername();

    boolean isAccountNonExpired();

    boolean isAccountNonLocked();

    boolean isCredentialsNonExpired();

    boolean isEnabled();
}
