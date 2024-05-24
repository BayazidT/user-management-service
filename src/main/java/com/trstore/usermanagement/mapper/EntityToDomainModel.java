package com.trstore.usermanagement.mapper;

import com.trstore.usermanagement.entity.AdminUserEntity;

import java.util.List;

public interface EntityToDomainModel <T, S>{
    T entityToDomainModelMapper(AdminUserEntity entity);
    List<T> entityToDomainModelMapperList(List<S> entity);
}
