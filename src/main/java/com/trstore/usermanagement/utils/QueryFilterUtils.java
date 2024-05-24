package com.trstore.usermanagement.utils;

import com.trstore.usermanagement.constant.QueryOperator;
import com.trstore.usermanagement.model.Filter;

public class QueryFilterUtils {

    public static <T> Filter generateIndividualFilter(String field, QueryOperator queryOperator, T value) {
        return Filter.builder()
                .field(field)
                .operator(queryOperator)
                .value(value)
                .build();
    }

}