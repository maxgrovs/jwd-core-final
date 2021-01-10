package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.domain.BaseEntity;

/**
 * Should be a builder for {@link BaseEntity} fields
 */
public abstract class Criteria<T extends BaseEntity> {

    Long id;
    String name;


    public Long getId() {
        // todo
        return id;
    }


    public String getName() {
        // todo
        return name;
    }

}
