package com.epam.jwd.core_final.service;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.context.impl.NassaContext;
import com.epam.jwd.core_final.domain.BaseEntity;

import java.io.IOException;
import java.util.Collection;

public class BaseEntityService<T extends BaseEntity> {

    private final Class<T> entityClass;

    protected BaseEntityService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public Collection<T> findAll() throws IOException {

        final ApplicationContext applicationContext = new NassaContext();

        Collection<T> entityList = applicationContext.retrieveBaseEntityList(entityClass);

        return entityList;
    }
}
