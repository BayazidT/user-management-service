package com.trstore.trstoreapi.mapper;


import com.trstore.trstoreapi.entity.AdminUserEntity;
import com.trstore.trstoreapi.entity.UserEntity;
import com.trstore.trstoreapi.model.UserResponseModel;
import com.trstore.trstoreapi.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AdminUserEntityToUserResponseModelMapper extends EntityToDomainModel<UserResponseModel, AdminUserEntity>{
}
