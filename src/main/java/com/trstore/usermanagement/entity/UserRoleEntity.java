package com.trstore.usermanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_roles")
public class UserRoleEntity extends GenericIntEntity<String, Integer>{

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private AdminRolesEntity roleEntities;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private AdminUserEntity userId;
}
