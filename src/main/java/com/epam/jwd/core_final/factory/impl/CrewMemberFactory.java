package com.epam.jwd.core_final.factory.impl;

import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.factory.EntityFactory;

// do the same for other entities
public class CrewMemberFactory implements EntityFactory<CrewMember> {

    @Override
    public CrewMember create(String... args) {


        return CrewMember.builder()
                .role(Long.valueOf( args[0]))
                .name(String.valueOf(args[1]))
                .rank(Long.valueOf(args[2]))
                .build();
    }
}
