package com.trstore.usermanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class GenericIntEntity<S, U>{

    @Id
    @GenericGenerator(
            name = "sequence_gen",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX,
                            value = "_id_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(generator = "sequence_gen")
    @Column(name = "id", unique = true,updatable = false,nullable = false)
    private Integer id;

}
