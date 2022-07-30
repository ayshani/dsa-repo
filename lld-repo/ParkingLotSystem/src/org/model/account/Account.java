package org.model.account;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Account {
    private String id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime lastAccess;
}
