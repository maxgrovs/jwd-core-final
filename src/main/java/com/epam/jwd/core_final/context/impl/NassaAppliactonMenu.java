package com.epam.jwd.core_final.context.impl;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.context.ApplicationMenu;

public class NassaAppliactonMenu implements ApplicationMenu {
    @Override
    public ApplicationContext getApplicationContext() {

        return NassaContext.getInstance();
    }

    @Override
    public Object printAvailableOptions() {

        return null;
    }

    @Override
    public Object handleUserInput(Object o) {

        return null;
    }
}
