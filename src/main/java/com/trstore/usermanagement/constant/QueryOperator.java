package com.trstore.usermanagement.constant;

import lombok.Getter;

@Getter
public enum QueryOperator {
    GREATER_THAN_EQUALS,
    LESS_THAN_EQUALS,
    RANGE,
    EQUALS,
    EQUALS_JOIN,
    LIKE,
    LIKE_JOIN,
    NOT_EQUALS,
    IN
}
