package com.userName.application.service.userIdentity;

import com.userName.application.model.UserIdentity.UserIdentity;
import com.userName.application.model.UserIdentity.dto.req.RegisterRequestDto;
import com.userName.application.model.UserIdentity.dto.res.RegisterResponseDto;

public interface UserIdentityService {

    UserIdentity registerUserIdentity(RegisterRequestDto request);

}
