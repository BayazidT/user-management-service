package com.trstore.usermanagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "admin_users")
public class AdminUserEntity  extends GenericEntity<String, UUID> implements UserDetails {

    @Column(name = "first_name", nullable = false, length = 255)
    private String firstName;

    @Column(name = "username", length = 255)
    private String username;

    @Column(name = "last_name", length = 255)
    private String lastName;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "remember_token", nullable = false, length = 255)
    private String rememberToken;

    @Column(name = "status", nullable = false)
    private Boolean status = true;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @JsonManagedReference
//    @OneToOne(mappedBy = "userId", cascade = CascadeType.ALL)
    @OneToOne(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserRoleEntity userRoleEntities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
