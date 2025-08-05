package com.userName.application.model.UserIdentity;

import jakarta.persistence.*;

@Entity
public class UserData {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private UserIdentity userIdentity;
}
