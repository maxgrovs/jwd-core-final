package com.epam.jwd.core_final.context.impl;

import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.factory.EntityFactory;
import com.epam.jwd.core_final.factory.impl.CrewMemberFactory;
import com.epam.jwd.core_final.factory.impl.SpaceshipFactory;
import org.junit.Test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class NassaContextTest {

    @Test
    public void retrieveBaseEntityList() {
    }

    @Test
    public void init() throws IOException {

        CrewMemberFactory factory = new CrewMemberFactory();

        File resources = Paths.get("src", "resources", "input", "crew").toFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(resources))) {

            List<CrewMember> crewMembers = Arrays.stream(reader.lines()
                    .collect(Collectors.toList())
                    .get(1).split(";"))
                    .collect(Collectors.toList()).stream()
                    .map(s -> s.split(","))
                    .map(factory::create)
                    .collect(Collectors.toList());

        //    crewMembers.forEach(System.out::println);

        }

        EntityFactory<Spaceship> spaceshipEntityFactory = new SpaceshipFactory();

        File baseOfSpaceships = Paths.get("src", "resources", "input", "spaceships").toFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(baseOfSpaceships))) {

            List<Spaceship> spaceships = reader.lines()
                    .filter(s -> !s.startsWith("#"))
                    .map(s -> s.split(";"))
                    .map(spaceshipEntityFactory::create)
                    .collect(Collectors.toList());

            spaceships.forEach(System.out::println);

        }

    }
}