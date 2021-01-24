package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.context.impl.NasaAppliactonMenu;
import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.criteria.SpaceshipCriteria;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.service.BaseEntityService;
import com.epam.jwd.core_final.service.SpaceshipService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NasaSpaceshipService extends BaseEntityService<Spaceship> implements SpaceshipService {


    public NasaSpaceshipService() {
        super(Spaceship.class);

    }

    @Override
    public List<Spaceship> findAllSpaceships() {

        List<Spaceship> spaceships = null;

        try {
            spaceships = new ArrayList<>(super.findAll());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return spaceships;
    }


    @Override
    public List<Spaceship> findAllSpaceshipsByCriteria(Criteria<? extends Spaceship> criteria) throws IOException {

        SpaceshipCriteria spaceshipCriteria = (SpaceshipCriteria) criteria;

        ArrayList<Spaceship> allSpaceships = new ArrayList<>(super.findAll());
        //  ArrayList<Spaceship> allSpaceships = new ArrayList<>(appliactonMenu.getAllContextSpaceships());

        List<Spaceship> spaceships = new ArrayList<>();

        if (spaceshipCriteria.getFlightDistance() != null) {
            spaceships = allSpaceships.stream()
                    .filter(spaceship -> spaceship.getFlightDistance() < spaceshipCriteria.getFlightDistance())
                    .collect(Collectors.toList());
        }

        if (spaceshipCriteria.getId() != null) {
            spaceships = allSpaceships.stream()
                    .filter(spaceship -> spaceship.getId().equals(spaceshipCriteria.getId()))
                    .collect(Collectors.toList());
        }
        if (spaceshipCriteria.getReadyForNextMissions() != null) {

            spaceships = allSpaceships.stream()
                    .filter(spaceship -> spaceship.getReadyForNextMissions().equals(spaceshipCriteria.getReadyForNextMissions()))
                    .collect(Collectors.toList());

        }

        return spaceships;
    }

    @Override
    public Optional<Spaceship> findSpaceshipByCriteria(Criteria<? extends Spaceship> criteria) {

        SpaceshipCriteria spaceshipCriteria = (SpaceshipCriteria) criteria;

        ArrayList<Spaceship> allSpaceships = new ArrayList<>(findAllSpaceships());
        //  ArrayList<Spaceship> allSpaceships = new ArrayList<>(appliactonMenu.getAllContextSpaceships());

        List<Spaceship> spaceships = new ArrayList<>();

        if (spaceshipCriteria.getId() != null) {
            spaceships = allSpaceships.stream()
                    .filter(spaceship -> spaceship.getId().equals(spaceshipCriteria.getId()))
                    .collect(Collectors.toList());
        }

        Optional<Spaceship> spaceship = spaceships.size() != 0 ? Optional.of(spaceships.get(0)) : Optional.empty();

        // System.out.println();

        return spaceship;
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
