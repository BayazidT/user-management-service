package com.trstore.usermanagement.mapper;

import java.util.List;

public interface DomainModelToEntity <T, S>{
    T domainModelToEntityMapper(S model);
    List<T> domainModelToEntityMapper(List<S> model);
}
