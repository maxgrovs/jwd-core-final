package com.epam.jwd.core_final.context;

import com.epam.jwd.core_final.context.impl.NassaAppliactonMenu;
import com.epam.jwd.core_final.context.impl.NassaContext;
import com.epam.jwd.core_final.exception.InvalidStateException;

import java.io.IOException;
import java.util.function.Supplier;

public interface Application {


    static ApplicationMenu start() throws InvalidStateException, IOException {

        final NassaAppliactonMenu nassaAppliactonMenu = new NassaAppliactonMenu();

        final Supplier<ApplicationContext> applicationContextSupplier = nassaAppliactonMenu::getApplicationContext; // todo

        final NassaContext nassaContext = NassaContext.getInstance();

        nassaContext.init();

        return () -> applicationContextSupplier.get();
    }
}
