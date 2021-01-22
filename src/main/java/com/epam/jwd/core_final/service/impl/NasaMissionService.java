package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.criteria.FlightMissionCriteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.FlightMission;
import com.epam.jwd.core_final.domain.MissionResult;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.factory.EntityFactory;
import com.epam.jwd.core_final.factory.impl.MissionFactory;
import com.epam.jwd.core_final.service.BaseEntityService;
import com.epam.jwd.core_final.service.CrewService;
import com.epam.jwd.core_final.service.MissionService;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NasaMissionService extends BaseEntityService<FlightMission> implements MissionService {

    FlightMissionCriteria missionCriteria;

    public NasaMissionService() {
        super(FlightMission.class);
    }

    @Override
    public List<FlightMission> findAllMissions() {

        EntityFactory<FlightMission> factory = new MissionFactory();

        File baseOfMissions = Paths.get("src", "resources", "output", "missions").toFile();
        List<FlightMission> missions = new ArrayList<>();

        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(baseOfMissions))) {

                missions =   reader.lines()
                        .filter(s -> !s.startsWith("#"))
                        .map(s -> s.split(";"))
                        .map(factory::create)
                        .collect(Collectors.toList());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return missions;
    }

    @Override
    public List<FlightMission> findAllMissionsByCriteria(Criteria<? extends FlightMission> criteria) {


        missionCriteria = (FlightMissionCriteria) criteria;

        List<FlightMission> allMissions = findAllMissions();

        List<FlightMission> missions = new ArrayList<>();

        if (missionCriteria.getMissionResult() != null) {
            missions = allMissions.stream()
                    .filter(mission -> mission.getMissionResult().equals(missionCriteria.getMissionResult()))
                    .collect(Collectors.toList());
        }



        return missions;
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

    public void writeMissionToFile(FlightMission flightMission) throws IOException {

        File mission = Paths.get("src", "resources", "output", "missions").toFile();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(mission, true))) {

            String s = flightMission.toString();

            writer.write("\n" + s);

        }
    }
}
