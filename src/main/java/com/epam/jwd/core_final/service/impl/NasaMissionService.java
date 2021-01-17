package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.FlightMission;
import com.epam.jwd.core_final.domain.MissionResult;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.service.BaseEntityService;
import com.epam.jwd.core_final.service.CrewService;
import com.epam.jwd.core_final.service.MissionService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class NasaMissionService extends BaseEntityService<FlightMission> implements MissionService {

    public NasaMissionService() {
        super(FlightMission.class);
    }

    @Override
    public List<FlightMission> findAllMissions() {
        return null;
    }

    @Override
    public List<FlightMission> findAllMissionsByCriteria(Criteria<? extends FlightMission> criteria) {
        return null;
    }

    @Override
    public Optional<FlightMission> findMissionByCriteria(Criteria<? extends FlightMission> criteria) {
        return Optional.empty();
    }

    @Override
    public FlightMission updateSpaceshipDetails(FlightMission flightMission) {
        return null;
    }

    @Override
    public FlightMission createMission(FlightMission flightMission) {

        return null;
    }



}
