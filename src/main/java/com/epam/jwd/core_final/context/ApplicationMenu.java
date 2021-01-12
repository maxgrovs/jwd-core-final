package com.epam.jwd.core_final.context;

import java.io.IOException;

// todo replace Object with your own types
@FunctionalInterface
public interface ApplicationMenu {

    ApplicationContext getApplicationContext();

    default Integer printAvailableOptions() {
        return null;
    }

    default Object handleUserInput(Integer o) throws IOException {
        return null;
    }
}
