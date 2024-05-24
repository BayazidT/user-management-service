package com.trstore.usermanagement.controller;

import com.trstore.usermanagement.entity.AdminUserEntity;
import com.trstore.usermanagement.mapper.AdminUserEntityToUserResponseModelMapper;
import com.trstore.usermanagement.mapper.AdminUserModelToAdminUserEntityModelMapper;
import com.trstore.usermanagement.model.Filter;
import com.trstore.usermanagement.model.UserModel;
import com.trstore.usermanagement.model.UserResponseModel;
import com.trstore.usermanagement.repository.AdminUserRepository;
import com.trstore.usermanagement.service.UserService;
import com.trstore.usermanagement.specificationbuilder.SpecificationBuilder;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    private final AdminUserRepository userRepository;
    private final AdminUserEntityToUserResponseModelMapper mapper;
    private final AdminUserModelToAdminUserEntityModelMapper modelMapper;
    private final SpecificationBuilder<AdminUserEntity> specificationBuilder;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @PostMapping("/user")
    ResponseEntity<UserResponseModel> createAdminUser(@RequestBody UserModel userModel){
        AdminUserEntity adminUserEntity = modelMapper.domainModelToEntityMapper(userModel);
        adminUserEntity.setPassword(passwordEncoder.encode("123456"));
        AdminUserEntity userEntity = userRepository.save(adminUserEntity);
        userService.assignRole(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.entityToDomainModelMapper(userEntity));
    }
    @GetMapping("/users")
    List<UserResponseModel> getAllUsers(@RequestParam(value = "page",required = true,defaultValue = "1") @NotNull @Validated Integer page, @RequestParam(value = "size",required = true,defaultValue = "10") @NotNull @Validated Integer size, @RequestParam(value = "search",required = false) @Validated String search) {
        page--;
        Pageable pageable = generatePaginationWithSort(page, size);
        Page<AdminUserEntity> entityList = userRepository.findAll(pageable);

        return mapper.entityToDomainModelMapperList(entityList.getContent());
    }
    @GetMapping("/user/{id}")
    ResponseEntity<UserResponseModel> getUserById(@PathVariable UUID id){
        AdminUserEntity userEntity = userRepository.findById(id).orElseThrow();
       return ResponseEntity.ok().body(mapper.entityToDomainModelMapper(userEntity));
    }
    @DeleteMapping("/user/{id}")
    ResponseEntity<String> deleteUserById(@PathVariable UUID id){
        AdminUserEntity userEntity = userRepository.findById(id).orElseThrow();
        userEntity.setStatus(Boolean.FALSE);
        userRepository.save(userEntity);
        return ResponseEntity.ok().body("User Delete Successful!");
    }
    @PutMapping("/user/{id}")
    ResponseEntity<UserResponseModel> updateUserById(@PathVariable UUID id, @RequestBody UserModel userModel){
        AdminUserEntity userEntity = userRepository.findById(id).orElseThrow();
        userEntity.setFirstName(userModel.getFirstName());
        userEntity.setLastName(userEntity.getLastName());
        userRepository.save(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.entityToDomainModelMapper(userEntity));
    }

    private Pageable generatePaginationWithSort(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        return PageRequest.of(page, size, sort);
    }
        private Specification<AdminUserEntity> generateSpecificationWithQueryFilters(List<Filter> filters) {
        Specification<AdminUserEntity> specs = null;
        Specification<AdminUserEntity> specForSearch = null;
        for (Filter filter : filters) {
            if (Objects.equals(filter.getField(), "firstName") || Objects.equals(filter.getField(), "lastName") || Objects.equals(filter.getField(), "email")) {
                Specification<AdminUserEntity> spec = specificationBuilder.createSpecification(filter);
                if (specForSearch == null) specForSearch = Specification.where(spec);
                else specForSearch = specForSearch.or(spec);
            } else {
                Specification<AdminUserEntity> spec = specificationBuilder.createSpecification(filter);
                if (specs == null) specs = Specification.where(spec);
                else specs = specs.and(spec);

            }
        }
        if (specs == null) specs = Specification.where(specForSearch);
        else specs = specs.and(specForSearch);
        return specs;
    }

}
