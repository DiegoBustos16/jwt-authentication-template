package com.userName.application.orchestrator.userIdentity;

import com.userName.application.model.UserIdentity.UserIdentity;
import com.userName.application.model.UserIdentity.dto.req.RegisterRequestDto;
import com.userName.application.model.UserIdentity.dto.res.RegisterResponseDto;
import com.userName.application.service.userIdentity.UserIdentityService;
import com.userName.application.utilities.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserIdentityUseCaseHandler implements UserIdentityOrchestrator{

    private final UserIdentityService userIdentityService;
    private final JwtUtils jwtUtils;

    @Override
    public RegisterResponseDto registerUserIdentity(RegisterRequestDto request) {
        UserIdentity registeredUser = userIdentityService.registerUserIdentity(request);
        String token = jwtUtils.generateToken(registeredUser.getUsername());
        return new RegisterResponseDto(token);
    }

}
