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

    public String createSpaceMission(){

        String name;
        LocalDate startDate;
        LocalDate endDate;
        Long missionsDistance;
        Spaceship assignedSpaceShift;
        List<CrewMember> assignedCrew;
        MissionResult missionResult;

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter missions name:\n");

        in.nextLine();

        System.out.println("Please enter start missions date:\n");

        // startDate = LocalDate.parse(in.nextLine()) ;

        //  Integer input = in.nextInt();

         in.close();

        //  System.out.println(name + " ");



        return null;
    }
}
