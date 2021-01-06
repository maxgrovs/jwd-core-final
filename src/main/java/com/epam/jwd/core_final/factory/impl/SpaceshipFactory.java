package com.epam.jwd.core_final.factory.impl;


import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.factory.EntityFactory;

// do the same for other entities
public class SpaceshipFactory implements EntityFactory<Spaceship> {

    @Override
    public Spaceship create(String... args) {


        return Spaceship.builder()
                .name(String.valueOf(args[0]))
                .flightDistance(Long.valueOf(args[1]))
                .crew(String.valueOf( args[2]))
                .build();
    }


}
