package com.userName.application.model.UserIdentity.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterRequestDto (
        @NotBlank(message = "Username must not be blank")
        @Size(max = 20, message = "Username must not exceed 20 characters")
        @Pattern(
                regexp = "^[a-zA-Z0-9_.@-]+$",
                message = "Username can only contain letters, numbers and the following characters: _ . @ -"
        )
        String username,

        @NotBlank(message = "Password must not be blank")
        @Size(min = 8, message = "Password must be at least 8 characters long")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$%&!?#]).+$",
                message = "Password must contain at least one lowercase letter, one uppercase letter, one number and one special character ($%&!?#)"
        )
        String password
)
{}