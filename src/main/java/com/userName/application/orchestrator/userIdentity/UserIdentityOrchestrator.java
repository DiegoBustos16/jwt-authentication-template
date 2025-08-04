package com.userName.application.orchestrator.userIdentity;

import com.userName.application.model.UserIdentity.UserIdentity;
import com.userName.application.model.UserIdentity.dto.req.RegisterRequestDto;
import com.userName.application.model.UserIdentity.dto.res.RegisterResponseDto;

public interface UserIdentityOrchestrator {

    RegisterResponseDto registerUserIdentity(RegisterRequestDto request);

}
