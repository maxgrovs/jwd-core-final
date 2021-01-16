package com.epam.jwd.core_final;

import com.epam.jwd.core_final.context.Application;

import com.epam.jwd.core_final.context.ApplicationMenu;
import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.exception.InvalidStateException;

import com.epam.jwd.core_final.service.impl.CrewMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, InvalidStateException {

       ApplicationMenu start = Application.start();



        /*File mission = Paths.get("src", "resources", "output", "mission").toFile();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(mission))) {

            String s = "Hello Grovs!";

            writer.write(s);

        }*/


        //  logger.info("hello world!");


    }


}