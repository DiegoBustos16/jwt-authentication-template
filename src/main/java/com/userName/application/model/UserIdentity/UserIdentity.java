package com.userName.application.model.UserIdentity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class UserIdentity {

    @Id
    private Long id;
    @NonNull
    private String username;
    @NonNull
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserData userData;
}
