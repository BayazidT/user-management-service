package com.trstore.usermanagement.mapper;


import com.trstore.usermanagement.entity.UserEntity;
import com.trstore.usermanagement.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserEntityToDomainModelMapper extends EntityToDomainModel<User, UserEntity>{
}
