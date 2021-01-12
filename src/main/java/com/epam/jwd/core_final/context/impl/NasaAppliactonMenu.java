package com.epam.jwd.core_final.context.impl;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.context.ApplicationMenu;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.service.CrewService;
import com.epam.jwd.core_final.service.SpaceshipService;
import com.epam.jwd.core_final.service.impl.CrewMemberService;
import com.epam.jwd.core_final.service.impl.NasaSpaceshipService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class NasaAppliactonMenu implements ApplicationMenu {

    CrewService crewService = new CrewMemberService();
    SpaceshipService spaceshipService = new NasaSpaceshipService();

    @Override
    public ApplicationContext getApplicationContext() {

        return NasaContext.getInstance();
    }

    @Override
    public Integer printAvailableOptions() {

        System.out.println("Please enter what do you want:\n" +
                "1 - show all spaceships\n" +
                "2 - show all crew members\n");

        Scanner in = new Scanner(System.in);

        Integer input = in.nextInt();

        in.close();

        return input;
    }

    @Override
    public Object handleUserInput(Integer input) throws IOException {


        switch (input) {
            case 1:
                List<Spaceship> allSpaceships = spaceshipService.findAllSpaceships();
                allSpaceships.forEach(System.out::println);
                break;
            case 2:
                List<CrewMember> allCrewMembers = crewService.findAllCrewMembers();
                allCrewMembers.forEach(System.out::println);
                break;
        }

        return null;
    }
}
