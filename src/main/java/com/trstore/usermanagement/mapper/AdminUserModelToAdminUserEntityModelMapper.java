package com.trstore.trstoreapi.mapper;


import com.trstore.trstoreapi.entity.AdminUserEntity;
import com.trstore.trstoreapi.model.UserModel;
import com.trstore.trstoreapi.model.UserResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AdminUserModelToAdminUserEntityModelMapper extends DomainModelToEntity<AdminUserEntity, UserModel>{
}
