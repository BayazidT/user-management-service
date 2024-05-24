package com.trstore.usermanagement.model;

import com.trstore.usermanagement.constant.QueryOperator;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Filter {

    private String field;
    private String joinField;
    private QueryOperator operator;
    private Object value;
    private Object rangeSecondValue;
    private List<?> values;

}
