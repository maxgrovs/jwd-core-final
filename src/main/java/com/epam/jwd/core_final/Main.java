package com.epam.jwd.core_final;

import com.epam.jwd.core_final.context.Application;
import com.epam.jwd.core_final.context.ApplicationMenu;
import com.epam.jwd.core_final.exception.InvalidStateException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, InvalidStateException {

        ApplicationMenu start = Application.start();

        //  logger.info("hello world!");


    }


}