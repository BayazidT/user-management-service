package com.trstore.usermanagement.mapper;


import com.trstore.usermanagement.entity.AdminUserEntity;
import com.trstore.usermanagement.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AdminUserModelToAdminUserEntityModelMapper extends DomainModelToEntity<AdminUserEntity, UserModel>{
}
