package com.trstore.usermanagement.repository;

import com.trstore.usermanagement.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer> {
}
