package com.trstore.usermanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "admin_roles")
public class AdminRolesEntity extends GenericIntEntity<String, Integer>{

    @OneToOne(mappedBy = "roleEntities", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserRoleEntity adminRoleEntity;

    private String name;

    private String slug;
}
