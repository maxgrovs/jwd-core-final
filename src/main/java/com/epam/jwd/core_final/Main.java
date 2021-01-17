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
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, InvalidStateException {

      //  ApplicationMenu start = Application.start();


       /* String s = "[CrewMember{role=PILOT, rank=FIRST_OFFICER, isReadyForNextMissions=true, id=78, name='Maximus Brandt'}," +
                "CrewMember{role=PILOT, rank=FIRST_OFFICER, isReadyForNextMissions=true, id=80, name='Maisy Perez'}, " +
                "CrewMember{role=MISSION_SPECIALIST, rank=CAPTAIN, isReadyForNextMissions=true, id=88, name='Jermaine Hester'}, " +
                "CrewMember{role=MISSION_SPECIALIST, rank=SECOND_OFFICER, isReadyForNextMissions=true, id=98, name='Jordyn Henson'}, " +
                "CrewMember{role=FLIGHT_ENGINEER, rank=CAPTAIN, isReadyForNextMissions=true, id=97, name='Sally Gonzales'}, " +
                "CrewMember{role=FLIGHT_ENGINEER, rank=TRAINEE, isReadyForNextMissions=true, id=99, name='Britney Dunn'}, " +
                "CrewMember{role=COMMANDER, rank=TRAINEE, isReadyForNextMissions=true, id=100, name='Shayan Mclellan'}]";

        s= s.substring(1);

        String[] crewMembers = s.split("CrewMember");

        for (String s1 : crewMembers
        ){
            System.out.println(s1);
        }*/


        /*String s = "Spaceship{crew={PILOT=2, MISSION_SPECIALIST=7, FLIGHT_ENGINEER=7, COMMANDER=2}, flightDistance=162029, isReadyForNextMissions=true, id=128, name='HWSS Orion'}";

        String[] split = s.split(",");

        for (String s1 : split) {
            System.out.println(s1);
        }*/


        /*File mission = Paths.get("src", "resources", "output", "missions").toFile();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(mission, true))) {

            String s = "Hello Grovs!";

            writer.write("\n" + s);

        }*/


        //  logger.info("hello world!");


    }


}