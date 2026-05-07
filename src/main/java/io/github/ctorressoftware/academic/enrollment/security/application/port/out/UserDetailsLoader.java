package io.github.ctorressoftware.academic.enrollment.security.application.port.out;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsLoader extends UserDetailsService {
    UserDetails loadUserById(String userId) throws UsernameNotFoundException;
}