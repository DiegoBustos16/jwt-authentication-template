package com.userName.application.controller.authController;

import com.userName.application.model.UserIdentity.dto.req.RegisterRequestDto;
import com.userName.application.model.UserIdentity.dto.res.RegisterResponseDto;
import com.userName.application.orchestrator.userIdentity.UserIdentityOrchestrator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserIdentityOrchestrator userIdentityOrchestrator;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register( @Valid @RequestBody RegisterRequestDto request) {
        return ResponseEntity.ok(userIdentityOrchestrator.registerUserIdentity(request));
    }
}
