package com.trstore.usermanagement.repository;

import com.trstore.usermanagement.entity.AdminUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AdminUserRepository extends JpaRepository<AdminUserEntity, UUID> {
    Optional<Object> findByUsername(String username);
}
