package com.epam.jwd.core_final.service;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.context.impl.NassaContext;
import com.epam.jwd.core_final.domain.BaseEntity;

import java.io.IOException;
import java.util.Collection;

public class BaseEntityService<T extends BaseEntity> {

    private final Class<T> entityClass;

    public Class<T> getEntityClass() {
        return entityClass;
    }

    protected BaseEntityService(Class<T> entityClass) {

        this.entityClass = entityClass;
    }

    public Collection<T> findAll() throws IOException {

        final ApplicationContext applicationContext = NassaContext.getInstance();

        Collection<T> entityList = applicationContext.retrieveBaseEntityList(this.entityClass);

        return entityList;
    }
}
