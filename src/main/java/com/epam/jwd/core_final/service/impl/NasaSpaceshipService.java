package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.service.BaseEntityService;
import com.epam.jwd.core_final.service.SpaceshipService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NasaSpaceshipService extends BaseEntityService<Spaceship> implements SpaceshipService {

    public NasaSpaceshipService() {
        super(Spaceship.class);
    }

    @Override
    public List<Spaceship> findAllSpaceships() throws IOException {

          return  new ArrayList<>(super.findAll());
    }

    @Override
    public List<Spaceship> findAllSpaceshipsByCriteria(Criteria<? extends Spaceship> criteria) {



        return null;
    }

    @Override
    public Optional<Spaceship> findSpaceshipByCriteria(Criteria<? extends Spaceship> criteria) {
        return Optional.empty();
    }

    @Override
    public Spaceship updateSpaceshipDetails(Spaceship spaceship) {
        return null;
    }

    @Override
    public void assignSpaceshipOnMission(Spaceship crewMember) throws RuntimeException {

    }

    @Override
    public Spaceship createSpaceship(Spaceship spaceship) throws RuntimeException {
        return null;
    }
}
