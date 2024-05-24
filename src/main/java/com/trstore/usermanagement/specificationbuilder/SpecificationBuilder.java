package com.trstore.usermanagement.specificationbuilder;

import com.trstore.usermanagement.model.Filter;
import com.trstore.usermanagement.utils.DateUtils;
import jakarta.persistence.criteria.Join;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Component
public class SpecificationBuilder<T> {
    public Specification<T> createSpecification(Filter input) {
        return switch (input.getOperator()) {
            case EQUALS -> ((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get(input.getField()), input.getValue()));
            case EQUALS_JOIN -> (root, query, criteriaBuilder) -> {
                Join<?, ?> join = root.join(input.getJoinField());
                return criteriaBuilder.equal(join.get(input.getField()), input.getValue());
            };
            case LIKE_JOIN -> (root, query, criteriaBuilder) -> {
                Join<?, ?> join = root.join(input.getJoinField());
                return criteriaBuilder.like(
                        criteriaBuilder.lower(join.get(input.getField())),
                        "%" + input.getValue().toString().toLowerCase() + "%"
                );
            };
            case NOT_EQUALS ->
                    (root, query, criteriaBuilder) -> criteriaBuilder.notEqual(root.get(input.getField()), input.getValue());
            case GREATER_THAN_EQUALS ->
                    (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(input.getField()), (Date) input.getValue());
            case LESS_THAN_EQUALS ->
                    (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(input.getField()), (Date) input.getValue());
            case RANGE -> (root, query, criteriaBuilder) -> {
                Date startOfDay = DateUtils.getStartOfDay((LocalDateTime) input.getValue());
                Date endOfDay = DateUtils.getEndOfDay((LocalDateTime) input.getRangeSecondValue());
                return criteriaBuilder.between(root.get(input.getField()), startOfDay, endOfDay);
            };
            case LIKE -> (root, query, criteriaBuilder) ->
                    criteriaBuilder.like(
                            criteriaBuilder.lower(root.get(input.getField())),
                            "%" + input.getValue().toString().toLowerCase() + "%"
                    );
            case IN -> (root, query, criteriaBuilder) ->
                    criteriaBuilder.in(root.get(input.getField())).value(input.getValues());
        };
    }
}