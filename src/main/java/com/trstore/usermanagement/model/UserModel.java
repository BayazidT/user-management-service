package com.trstore.usermanagement.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String rememberToken;

    private Boolean status = true;

}
