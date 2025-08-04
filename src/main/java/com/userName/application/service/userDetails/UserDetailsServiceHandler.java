package com.userName.application.service.userDetails;

import com.userName.application.model.UserIdentity.UserIdentity;
import com.userName.application.repository.UserIdentityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceHandler implements UserDetailsService {

    private final UserIdentityRepository userIdentityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserIdentity userIdentity = userIdentityRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("The user " + username + " does not exists"));

        return User
                .withUsername(userIdentity.getUsername())
                .password(userIdentity.getPassword())
                .build();
    }
}
