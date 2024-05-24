package com.trstore.usermanagement.user;

import com.trstore.usermanagement.user.Role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
//    private Integer id;
    private String name;
    private String username;
    private String email;
    private boolean status;
    private Role role;
}
