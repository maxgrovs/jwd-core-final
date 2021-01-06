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
import java.util.List;
import java.util.stream.Collectors;


// todo
public class NassaContext implements ApplicationContext {

    // no getters/setters for them
    private Collection<CrewMember> crewMembers = new ArrayList<>();
    private Collection<Spaceship> spaceships = new ArrayList<>();

    @Override
    public <T extends BaseEntity> Collection<T> retrieveBaseEntityList(Class<T> tClass) throws IOException {

        Collection<T> result = new ArrayList<>();

        if (tClass.getSimpleName().equals("CrewMember")) {
            result = (Collection<T>) crewMembers;
        }else
            if (tClass.getSimpleName().equals("Spaceship")){

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
    public void init() throws InvalidStateException, IOException {

        EntityFactory<CrewMember> crewMemberFactory = new CrewMemberFactory();
        EntityFactory<Spaceship> spaceshipEntityFactory = new SpaceshipFactory();

        File baseOfCrewMembers = Paths.get("src", "resources", "input", "crew").toFile();
        File baseOfSpaceships = Paths.get("src", "resources", "input", "spaceships").toFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(baseOfCrewMembers))) {

            crewMembers = Arrays.stream(reader.lines()
                    .collect(Collectors.toList())
                    .get(1).split(";"))
                    .collect(Collectors.toList()).stream()
                    .map(s -> s.split(","))
                    .map(crewMemberFactory::create)
                    .collect(Collectors.toList());
        }


        try (BufferedReader reader = new BufferedReader(new FileReader(baseOfSpaceships))) {

            spaceships = reader.lines()
                    .filter(s -> !s.startsWith("#"))
                    .map(s -> s.split(";"))
                    .map(spaceshipEntityFactory::create)
                    .collect(Collectors.toList());

        }


        // final Collection<CrewMember> crewMembers = this.retrieveBaseEntityList(CrewMember.class);

        throw new InvalidStateException();
    }
}
