package com.trstore.trstoreapi.repository;

import com.trstore.trstoreapi.entity.AdminUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminUserRepository extends JpaRepository<AdminUserEntity, UUID> {
}
