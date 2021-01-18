package com.epam.jwd.core_final.factory.impl;


import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.criteria.SpaceshipCriteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.FlightMission;
import com.epam.jwd.core_final.domain.MissionResult;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.factory.EntityFactory;
import com.epam.jwd.core_final.service.SpaceshipService;
import com.epam.jwd.core_final.service.impl.CrewMemberService;
import com.epam.jwd.core_final.service.impl.NasaSpaceshipService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// do the same for other entities
public class MissionFactory implements EntityFactory<FlightMission> {

    SpaceshipCriteria spaceshipCriteria;
    NasaSpaceshipService spaceshipService = new NasaSpaceshipService();
    CrewMemberCriteria memberCriteria;
    CrewMemberService memberService = new CrewMemberService();

    @Override
    public FlightMission create(String... args) {

        String[] spaceShipDetails = args[4].split(",");
        Long id = Long.valueOf(spaceShipDetails[6].substring(4));

        spaceshipCriteria = SpaceshipCriteria.builder().id(id).build();

        Spaceship spaceship = spaceshipService.findSpaceshipByCriteria(spaceshipCriteria).get();

        String crewDetails = args[5].substring(1);

        String[] crewMembers = crewDetails.split("CrewMember");

        List<CrewMember> crewMemberList = Arrays.stream(crewMembers)
                .skip(1)
                .map(s -> s.split(","))
                .map(strings -> strings[3].substring(4))
                .map(Long::valueOf)
                .map(ids -> memberService.findCrewMemberByCriteria(CrewMemberCriteria.builder().id(ids).build()))
                .map(Optional::get)
                .collect(Collectors.toList());


        FlightMission flightMission = FlightMission.builder()
                .name(args[0])
                .startDate(LocalDate.parse(args[1]))
                .endDate(LocalDate.parse(args[2]))
                .missionsDistance(Long.valueOf(args[3]))
                .assignedSpaceShift(spaceship) //[4]
                .assignedCrew(crewMemberList) //[5]
                .missionResult(MissionResult.PLANNED)

                .build();

        return flightMission;
    }


}
