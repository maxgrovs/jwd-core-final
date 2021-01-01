package com.epam.jwd.core_final.factory.impl;

import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.factory.EntityFactory;

// do the same for other entities
public class CrewMemberFactory implements EntityFactory<CrewMember> {

    @Override
    public CrewMember create(Object... args) {

        return CrewMember.builder()
                .id((Long) args[0])
                .name(String.valueOf(args[1]))
                .role((Long) args[2])
                .rank((Long) args[3])
                .build();
    }
}
