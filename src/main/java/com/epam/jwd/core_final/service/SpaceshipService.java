package com.epam.jwd.core_final.service;

import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.domain.Spaceship;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * All its implementations should be a singleton
 * You have to use streamAPI for filtering, mapping, collecting, iterating
 */
public interface SpaceshipService {

    List<Spaceship> findAllSpaceships() throws IOException;

    List<Spaceship> findAllSpaceshipsByCriteria(Criteria<? extends Spaceship> criteria) throws IOException;

    Optional<Spaceship> findSpaceshipByCriteria(Criteria<? extends Spaceship> criteria) throws IOException;

    Spaceship updateSpaceshipDetails(Spaceship spaceship);

    // todo create custom exception for case, when spaceship is not able to be assigned
    void assignSpaceshipOnMission(Spaceship crewMember) throws RuntimeException;

    // todo create custom exception for case, when crewMember is not able to be created (for example - duplicate.
    // spaceship unique criteria - only name!
    Spaceship createSpaceship(Spaceship spaceship) throws RuntimeException;
}
