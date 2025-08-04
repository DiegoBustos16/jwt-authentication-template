package com.userName.application.service.userIdentity;

import com.userName.application.controller.advice.exception.DuplicateResourceException;
import com.userName.application.model.UserIdentity.UserIdentity;
import com.userName.application.model.UserIdentity.dto.req.RegisterRequestDto;
import com.userName.application.model.UserIdentity.dto.res.RegisterResponseDto;
import com.userName.application.repository.UserIdentityRepository;
import com.userName.application.utilities.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserIdentityServiceHandler implements UserIdentityService {

    private final UserIdentityRepository userIdentityRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @Override
    public UserIdentity registerUserIdentity(RegisterRequestDto request) {
        userIdentityRepository.findByUsername(request.username())
                .ifPresent(value -> {
                    throw new DuplicateResourceException("A resource already exists with the entered data.");
                });

        String hashedPassword = passwordEncoder.encode(request.password());

        return userIdentityRepository.save(new UserIdentity(request.username(), hashedPassword));
    }

}
