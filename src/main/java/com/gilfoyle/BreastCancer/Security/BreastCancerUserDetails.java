package com.gilfoyle.BreastCancer.Security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.gilfoyle.BreastCancer.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class BreastCancerUserDetails implements UserDetails {

    private Set<GrantedAuthority> authorities;
    //private List<Role> roles;
    //private List<Privilege> privileges;
    private final User delegate;

    public BreastCancerUserDetails(User delegate) {
        this.delegate = delegate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return delegate.getSecurityUser().getPassword();
    }

    @Override
    public String getUsername() {
        return delegate.getSecurityUser().getUsername();
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
