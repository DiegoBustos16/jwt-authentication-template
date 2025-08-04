package com.userName.application.model.UserIdentity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class UserIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(nullable = false, unique = true)
    private String username;
    @NonNull
    @Column(nullable = false)
    private String password;

    @OneToOne(mappedBy = "userIdentity", cascade = CascadeType.ALL)
    private UserData userData;
}
