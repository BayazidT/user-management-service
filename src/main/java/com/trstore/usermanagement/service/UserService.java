package com.trstore.usermanagement.service;

import com.trstore.usermanagement.entity.AdminRolesEntity;
import com.trstore.usermanagement.entity.AdminUserEntity;
import com.trstore.usermanagement.entity.UserEntity;
import com.trstore.usermanagement.entity.UserRoleEntity;
import com.trstore.usermanagement.repository.UserRoleRepository;
import com.trstore.usermanagement.user.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }
    public boolean isUserNameExists(String userName){
        Optional<UserEntity> alreadyExits = userRepository.findByUsername(userName);
        return alreadyExits.isPresent();
    }
    public boolean isEmailExists(String email){
        Optional<UserEntity> alreadyExits = userRepository.findByEmail(email);
        return alreadyExits.isPresent();
    }


    public void assignRole(AdminUserEntity userEntity) {
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        AdminRolesEntity aRoleEntity = new AdminRolesEntity();
        aRoleEntity.setId(4);
        aRoleEntity.setAdminRoleEntity(userRoleEntity);
        userRoleEntity.setRoleEntities(aRoleEntity);
        userRoleEntity.setUserId(userEntity);
        userRoleRepository.save(userRoleEntity);
    }
}
