package com.epam.jwd.core_final.context.impl;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.context.ApplicationMenu;
import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.criteria.SpaceshipCriteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.MissionResult;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.exception.InvalidStateException;
import com.epam.jwd.core_final.service.CrewService;
import com.epam.jwd.core_final.service.MissionService;
import com.epam.jwd.core_final.service.SpaceshipService;
import com.epam.jwd.core_final.service.impl.CrewMemberService;
import com.epam.jwd.core_final.service.impl.NasaMissionService;
import com.epam.jwd.core_final.service.impl.NasaSpaceshipService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class NasaAppliactonMenu implements ApplicationMenu {

    CrewService crewService = new CrewMemberService();
    SpaceshipService spaceshipService = new NasaSpaceshipService();
    NasaMissionService missionService = new NasaMissionService();
    SpaceshipCriteria spaceshipCriteria;
    CrewMemberCriteria crewMemberCriteria;

    private final Scanner in = new Scanner(System.in);

    @Override
    public ApplicationContext getApplicationContext() {

        return NasaContext.getInstance();
    }





    @Override
    public Integer printAvailableOptions() {

        System.out.println("\nPlease enter what do you want:\n" +
                "1 - show all spaceships\n" +
                "2 - show all crew members\n" +
                "3 - create space mission\n" +
                "0 - to exit");

        return in.nextInt();
    }

    @Override
    public String handleUserInput(Integer input) throws IOException, InvalidStateException {

        String result = "start";

        switch (input) {
            case 1:
                List<Spaceship> allSpaceships = spaceshipService.findAllSpaceships();
                allSpaceships.forEach(System.out::println);

                break;
            case 2:
                List<CrewMember> allCrewMembers = crewService.findAllCrewMembers();
                allCrewMembers.forEach(System.out::println);

                break;
            case 3:
                createSpaceMission();

                break;

            case 0:
                result = "exit";

                break;
            default:
                throw new InvalidStateException();
        }


        return result;
    }

    public void createSpaceMission() throws IOException {
        String name;
        LocalDate startDate;
        LocalDate endDate;
        Long missionsDistance;
        Spaceship assignedSpaceShift;
        List<CrewMember> assignedCrew;
        MissionResult missionResult;

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter missions name:");
        name = in.nextLine();

        System.out.println("Please enter start missions date in format \"yyyy-MM-dd\":");
        startDate = LocalDate.parse(in.nextLine());

        System.out.println("Please enter end missions date in format \"yyyy-MM-dd\":");
        endDate = LocalDate.parse(in.nextLine());

        System.out.println("Please enter missions distance:");
        missionsDistance = Long.valueOf(in.nextLine());

        System.out.println("Please choice spaceship and enter id:\n");
        spaceshipCriteria = SpaceshipCriteria.builder().flightDistance(missionsDistance).build();

        List<Spaceship> allSpaceshipsByCriteria = spaceshipService.findAllSpaceshipsByCriteria(spaceshipCriteria);
        allSpaceshipsByCriteria.forEach(System.out::println);

        spaceshipCriteria = SpaceshipCriteria.builder().id(Long.valueOf(in.nextLine())).build();

        assignedSpaceShift = spaceshipService.findAllSpaceshipsByCriteria(spaceshipCriteria).get(0);

        System.out.println("Please choice crew members and enter id:\n");
       // crewMemberCriteria = CrewMemberCriteria.builder().

                in.close();

        //  System.out.println(name + " ");



    }

}
