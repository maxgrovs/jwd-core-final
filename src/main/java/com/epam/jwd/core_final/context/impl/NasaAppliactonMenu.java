package com.epam.jwd.core_final.context.impl;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.context.ApplicationMenu;
import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.criteria.SpaceshipCriteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.MissionResult;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.exception.InvalidStateException;
import com.epam.jwd.core_final.service.SpaceshipService;
import com.epam.jwd.core_final.service.impl.CrewMemberService;
import com.epam.jwd.core_final.service.impl.NasaMissionService;
import com.epam.jwd.core_final.service.impl.NasaSpaceshipService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class NasaAppliactonMenu implements ApplicationMenu {

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

    String fetchMissionName = "Please enter missions name:";
    String fetchMissionsDistance = "\nPlease enter missions distance:";
    String fetchSpaceShip = "\nPlease choice spaceship and enter id:\n";
    String fetchPilots = "\nPlease choice pilots:\n";
    String fetchMissionSpecialists = "\nPlease choice mission specialists:\n";
    String fetchFlightEngineers = "\nPlease choice flight engineer:\n";
    String fetchCommanders = "\nPlease choice commanders:\n";
    String fetchStartDate = "\nPlease enter start date:\n";
    String fetchEndDate = "\nPlease enter end date:\n";


    String options = mainMenu;
    String restartMenu = "start";

    @Override
    public ApplicationContext getApplicationContext() {

        return NasaContext.getInstance();
    }


    public void startMainMenu() throws IOException, InvalidStateException {

        System.out.println("\nWelcome to NASA!\n");


        while (!restartMenu.equals("exit")) {

            System.out.println(options);

            String userInput = printAvailableOptions(options);

            if (options.equals(mainMenu)) {

                handleUserInput(userInput);

            } else {
                options = handleMissions(userInput);

            }
        }
    }


    @Override
    public String printAvailableOptions(String options) {

        //  System.out.println(options);

        return in.nextLine();
    }

    //---------------------
    String name;
    LocalDate startDate;
    LocalDate endDate;
    Long missionsDistance;
    Spaceship assignedSpaceShift = null;
    List<CrewMember> assignedCrew = null;
    MissionResult missionResult;
    String [] missionDetails;
    //---------------------

    CrewMemberService crewService = new CrewMemberService();

    public String handleMissions(String input) throws IOException {

        String nextOptions = mainMenu;

        if (options.equals(fetchMissionName)) {
            name = input;
            nextOptions = fetchMissionsDistance;
        }
        if (options.equals(fetchMissionsDistance)) {
            missionsDistance = Long.valueOf(input);

            spaceshipCriteria = SpaceshipCriteria.builder().flightDistance(missionsDistance).build();

            List<Spaceship> allSpaceshipsByCriteria = spaceshipService.findAllSpaceshipsByCriteria(spaceshipCriteria);
            allSpaceshipsByCriteria.forEach(System.out::println);

            nextOptions = fetchSpaceShip;
        }
        if (options.equals(fetchSpaceShip)) {

            spaceshipCriteria = SpaceshipCriteria.builder().id(Long.valueOf(input)).build();
            Optional<Spaceship> spaceshipByCriteria = spaceshipService.findSpaceshipByCriteria(spaceshipCriteria);

            assignedSpaceShift = spaceshipByCriteria.get();
            System.out.println(assignedSpaceShift);
            System.out.println();

            crewMemberCriteria = CrewMemberCriteria.builder().roleId(3L).build();
            crewService.findAllCrewMembersByCriteria(crewMemberCriteria).forEach(System.out::println);

            nextOptions = fetchPilots;
        }
        if (options.equals(fetchPilots)) {

            List<CrewMember> crewMembers = crewService.choiceCrewMembers(input);
            crewMembers.forEach(System.out::println);
            System.out.println();

            assignedCrew = new ArrayList<>(crewMembers);

            crewMemberCriteria = CrewMemberCriteria.builder().roleId(1L).build();
            crewService.findAllCrewMembersByCriteria(crewMemberCriteria).forEach(System.out::println);

            nextOptions = fetchMissionSpecialists;

        }
        if (options.equals(fetchMissionSpecialists)) {

            List<CrewMember> crewMembers = crewService.choiceCrewMembers(input);
            crewMembers.forEach(System.out::println);
            System.out.println();

            assignedCrew.addAll(crewMembers);

            crewMemberCriteria = CrewMemberCriteria.builder().roleId(2L).build();
            crewService.findAllCrewMembersByCriteria(crewMemberCriteria).forEach(System.out::println);

            nextOptions = fetchFlightEngineers;
        }
        if (options.equals(fetchFlightEngineers)) {

            List<CrewMember> crewMembers = crewService.choiceCrewMembers(input);
            crewMembers.forEach(System.out::println);
            System.out.println();

            assignedCrew.addAll(crewMembers);

            crewMemberCriteria = CrewMemberCriteria.builder().roleId(4L).build();
            crewService.findAllCrewMembersByCriteria(crewMemberCriteria).forEach(System.out::println);

            nextOptions = fetchCommanders;

        }
        if (options.equals(fetchCommanders)) {

            List<CrewMember> crewMembers = crewService.choiceCrewMembers(input);
            crewMembers.forEach(System.out::println);
            System.out.println();

            assignedCrew.addAll(crewMembers);
            assignedCrew.forEach(System.out::println);

            nextOptions = fetchStartDate;
        }
        if (options.equals(fetchStartDate)) {

            startDate = LocalDate.parse(input);
            System.out.println();

            nextOptions = fetchEndDate;
        }
        if (options.equals(fetchEndDate)) {

            endDate = LocalDate.parse(input);
            System.out.println();

            String mission = name + ";" + startDate + ";" + endDate + ";" + missionsDistance + ";" +
                    assignedSpaceShift + ";" + assignedCrew;

            System.out.println(mission);

            missionDetails = mission.split(";");

        }


        return nextOptions;
    }


    @Override
    public String handleUserInput(String input) throws IOException, InvalidStateException {

        String result = "start";

        switch (input) {
            case "1":
                List<Spaceship> allSpaceships = spaceshipService.findAllSpaceships();
                allSpaceships.forEach(System.out::println);

                break;
            case "2":
                List<CrewMember> allCrewMembers = crewService.findAllCrewMembers();
                allCrewMembers.forEach(System.out::println);

                break;
            case "3":
                options = fetchMissionName;

                break;

            case "0":
                restartMenu = "exit";

                break;
            default:
                throw new InvalidStateException();
        }


        return result;
    }

    public void createSpaceMission() throws IOException {

    }

}
