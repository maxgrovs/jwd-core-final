package com.epam.jwd.core_final.context;

import com.epam.jwd.core_final.context.impl.NasaAppliactonMenu;
import com.epam.jwd.core_final.context.impl.NasaContext;
import com.epam.jwd.core_final.exception.InvalidStateException;

import java.io.IOException;
import java.util.function.Supplier;

public interface Application {


    static ApplicationMenu start() throws InvalidStateException, IOException {

        System.out.println("\nWelcome to NASA!\n");
        String restartMenu = "start";

        final NasaAppliactonMenu nasaAppliactonMenu = new NasaAppliactonMenu();

        final Supplier<ApplicationContext> applicationContextSupplier = nasaAppliactonMenu::getApplicationContext; // todo

        final NasaContext nasaContext = NasaContext.getInstance();

        nasaContext.init();

        while (restartMenu.equals("start")){

            int userInput = (int) nasaAppliactonMenu.printAvailableOptions();

            restartMenu = nasaAppliactonMenu.handleUserInput(userInput);

        }

        return applicationContextSupplier::get;

    }
}
