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
import java.util.Optional;
import java.util.Scanner;

public class NasaAppliactonMenu implements ApplicationMenu {

    CrewMemberService crewService = new CrewMemberService();
    SpaceshipService spaceshipService = new NasaSpaceshipService();
    NasaMissionService missionService = new NasaMissionService();
    SpaceshipCriteria spaceshipCriteria;
    CrewMemberCriteria crewMemberCriteria;

    private final Scanner in = new Scanner(System.in);

    String mainMenu = "\nPlease enter what do you want:\n" +
            "1 - show all spaceships\n" +
            "2 - show all crew members\n" +
            "3 - create space mission\n" +
            "0 - to exit";

    @Override
    public ApplicationContext getApplicationContext() {

        return NasaContext.getInstance();
    }


    public void startMainMenu() throws IOException, InvalidStateException {

        System.out.println("\nWelcome to NASA!\n");
        String restartMenu = "start";

        while (restartMenu.equals("start")) {

            int userInput = (int) printAvailableOptions(mainMenu);

            restartMenu = handleUserInput(userInput);

        }

    }


    @Override
    public Integer printAvailableOptions(String options) {

        System.out.println(options);

        return in.nextInt();
    }

    public String printMissionOptions() {//""""""""""""""""""""""""""""""""""""""

        System.out.println("command");

        return in.nextLine();
    }

    public void handleMissions(String input) {
        System.out.println(input);
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
                handleMissions(printMissionOptions());

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
        Spaceship assignedSpaceShift = null;
        List<CrewMember> assignedCrew;
        MissionResult missionResult;

        Scanner in = new Scanner(System.in);

       /* System.out.println("Please enter missions name:");
        name = in.nextLine();

        System.out.println("\nPlease enter start missions date in format \"yyyy-MM-dd\":");
        startDate = LocalDate.parse(in.nextLine());

        System.out.println("\nPlease enter end missions date in format \"yyyy-MM-dd\":");
        endDate = LocalDate.parse(in.nextLine());*/

        /*System.out.println("\nPlease enter missions distance:");
        missionsDistance = Long.valueOf(in.nextLine());


        spaceshipCriteria = SpaceshipCriteria.builder().flightDistance(missionsDistance).build();

        List<Spaceship> allSpaceshipsByCriteria = spaceshipService.findAllSpaceshipsByCriteria(spaceshipCriteria);
        allSpaceshipsByCriteria.forEach(System.out::println);

        System.out.println("\nPlease choice spaceship and enter id:\n");

        spaceshipCriteria = SpaceshipCriteria.builder().id(Long.valueOf(in.nextLine())).build();
        Optional<Spaceship> spaceshipByCriteria = spaceshipService.findSpaceshipByCriteria(spaceshipCriteria);

        assignedSpaceShift = spaceshipByCriteria.get();*/

        System.out.println("\nPlease choice crew members and enter their id:\n");

        crewMemberCriteria = CrewMemberCriteria.builder().roleId(3L).build();
        crewService.findAllCrewMembersByCriteria(crewMemberCriteria).forEach(System.out::println);

        //   System.out.println("\nYour choice is: " + assignedSpaceShift.toString());

        System.out.println("\nPlease choice pilots:\n");


        List<CrewMember> pilots = crewService.choiceCrewMembers(in.nextLine()); // dont work!

       /* crewMemberCriteria = CrewMemberCriteria.builder().roleId(1L).build();
        crewService.findAllCrewMembersByCriteria(crewMemberCriteria).forEach(System.out::println);*/

       /* System.out.println("\nPlease choice mission specialists:\n");
        List<CrewMember> specialists = crewService.choiceCrewMembers(in.nextLine());*/
        //

        in.close();

        //  System.out.println(name + " ");


    }

}
