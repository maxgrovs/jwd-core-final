package com.epam.jwd.core_final.context.impl;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.context.ApplicationMenu;

import java.util.Scanner;

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

        Scanner in = new Scanner(System.in);

        System.out.print("Input start of Date: ");





        int num = in.nextInt();

        System.out.printf("Your number: %d \n", num);
        in.close();

        return null;
    }
}
