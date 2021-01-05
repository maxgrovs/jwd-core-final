package com.epam.jwd.core_final.context.impl;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.domain.BaseEntity;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.exception.InvalidStateException;
import com.epam.jwd.core_final.factory.impl.CrewMemberFactory;
import com.epam.jwd.core_final.service.BaseEntityService;
import com.epam.jwd.core_final.service.impl.CrewMemberService;


import java.io.*;
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

        CrewMemberFactory factory = new CrewMemberFactory();

        File resources = Paths.get("src", "resources", "input", "crew").toFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(resources))) {

            Collection<CrewMember> crewMemberList = Arrays.stream(reader.lines()
                    .collect(Collectors.toList())
                    .get(1).split(";"))
                    .collect(Collectors.toList()).stream()
                    .map(s -> s.split(","))
                    .map(factory::create)
                    .collect(Collectors.toList());


        }

        return null;
    }

    /**
     * You have to read input files, populate collections
     *
     * @throws InvalidStateException
     */
    @Override
    public void init() throws InvalidStateException, IOException {

        final Collection<CrewMember> crewMembers = this.retrieveBaseEntityList(CrewMember.class);

        throw new InvalidStateException();
    }
}
