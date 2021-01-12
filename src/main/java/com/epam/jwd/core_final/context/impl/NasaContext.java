package com.epam.jwd.core_final.context.impl;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.domain.BaseEntity;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.exception.InvalidStateException;
import com.epam.jwd.core_final.factory.EntityFactory;
import com.epam.jwd.core_final.factory.impl.CrewMemberFactory;
import com.epam.jwd.core_final.factory.impl.SpaceshipFactory;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


// todo
public class NasaContext implements ApplicationContext {

    // no getters/setters for them
    private Collection<CrewMember> crewMembers = new ArrayList<>();
    private Collection<Spaceship> spaceships = new ArrayList<>();


    private NasaContext() {
    }

    private static final NasaContext INSTANCE = new NasaContext();

    public static NasaContext getInstance() {
        return INSTANCE;
    }

    @Override
    public <T extends BaseEntity> Collection<T> retrieveBaseEntityList(Class<T> tClass) {

        Collection<T> result = new ArrayList<>();

        if (tClass.equals(CrewMember.class)) {
            result = (Collection<T>) this.crewMembers;

        } else if (tClass.getSimpleName().equals("Spaceship")) {

            result = (Collection<T>) spaceships;
        }

        return result;
    }

    /**
     * You have to read input files, populate collections
     *
     * @throws InvalidStateException
     */
    @Override
    public void init() throws InvalidStateException, java.io.IOException {

        File baseOfSpaceships = Paths.get("src", "resources", "input", "spaceships").toFile();

        File baseOfCrewMembers = Paths.get("src", "resources", "input", "crew").toFile();

        crewMembers = initCrewmember(baseOfCrewMembers);

        spaceships = initSpaceship(baseOfSpaceships);

        //  throw new InvalidStateException();
    }


    public Collection<Spaceship> initSpaceship(File fileSpaceships) throws IOException {

        EntityFactory<Spaceship> spaceshipEntityFactory = new SpaceshipFactory();


        Collection<Spaceship> spaceshipList;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileSpaceships))) {

            spaceshipList = reader.lines()
                    .filter(s -> !s.startsWith("#"))
                    .map(s -> s.split(";"))
                    .map(spaceshipEntityFactory::create)
                    .collect(Collectors.toList());

        }

        return spaceshipList;
    }


    public Collection<CrewMember> initCrewmember(File fileCrewmembers) throws IOException {

        EntityFactory<CrewMember> crewMemberFactory = new CrewMemberFactory();

        Collection<CrewMember> memberList;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileCrewmembers))) {

            memberList = Arrays.stream(reader.lines()
                    .collect(Collectors.toList())
                    .get(1).split(";"))
                    .collect(Collectors.toList()).stream()
                    .map(s -> s.split(","))
                    .map(crewMemberFactory::create)
                    .collect(Collectors.toList());
        }

        return memberList;
    }

}
