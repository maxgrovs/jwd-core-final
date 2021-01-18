package com.epam.jwd.core_final;

import com.epam.jwd.core_final.context.Application;

import com.epam.jwd.core_final.context.ApplicationMenu;
import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.FlightMission;
import com.epam.jwd.core_final.exception.InvalidStateException;

import com.epam.jwd.core_final.factory.impl.MissionFactory;
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

        ApplicationMenu start = Application.start();

        String mission = "dddd;" +
                "2021-01-18;" +
                "2021-01-19;" +
                "300000;" +
                "Spaceship{crew={FLIGHT_ENGINEER=7, MISSION_SPECIALIST=7, PILOT=2, COMMANDER=2}, " +
                "flightDistance=162029, isReadyForNextMissions=true, id=128, name='HWSS Orion'};" +
                "[CrewMember{role=PILOT, rank=FIRST_OFFICER, isReadyForNextMissions=true, id=78, name='Maximus Brandt'}, " +
                "CrewMember{role=PILOT, rank=FIRST_OFFICER, isReadyForNextMissions=true, id=80, name='Maisy Perez'}, " +
                "CrewMember{role=MISSION_SPECIALIST, rank=SECOND_OFFICER, isReadyForNextMissions=true, id=98, " +
                "name='Jordyn Henson'}, " +
                "CrewMember{role=FLIGHT_ENGINEER, rank=TRAINEE, isReadyForNextMissions=true, id=99, name='Britney Dunn'}, " +
                "CrewMember{role=COMMANDER, rank=TRAINEE, isReadyForNextMissions=true, id=100, name='Shayan Mclellan'}]\n";

        String[] missionsDetails = mission.split(";");

        MissionFactory missionFactory = new MissionFactory();

        FlightMission flightMission = missionFactory.create(missionsDetails);

        System.out.println(flightMission);


        /*File mission = Paths.get("src", "resources", "output", "missions").toFile();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(mission, true))) {

            String s = "Hello Grovs!";

            writer.write("\n" + s);

        }*/


        //  logger.info("hello world!");


    }


}