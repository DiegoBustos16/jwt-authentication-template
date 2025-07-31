package com.userName.application.model;

import jakarta.persistence.Id;
import lombok.*;

@Data
public abstract class UserEntity {

    @Id
    private Long id;
    private String username;
    private String password;
}
