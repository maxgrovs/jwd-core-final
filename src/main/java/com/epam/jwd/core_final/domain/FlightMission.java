package com.epam.jwd.core_final.domain;

import java.time.LocalDate;
import java.util.List;

/**
 * Expected fields:
 * <p>
 * missions name {@link String}
 * start date {@link java.time.LocalDate}
 * end date {@link java.time.LocalDate}
 * distance {@link Long} - missions distance
 * assignedSpaceShift {@link Spaceship} - not defined by default
 * assignedCrew {@link java.util.List<CrewMember>} - list of missions members based on ship capacity - not defined by default
 * missionResult {@link MissionResult}
 */
public class FlightMission extends AbstractBaseEntity {
    // todo

    String missionsName;
    LocalDate startDate;
    LocalDate endDate;
    Long missionsDistance;
    Spaceship assignedSpaceShift;
    List<CrewMember> assignedCrew;
    MissionResult missionResult;

    public FlightMission(Long id, String name, String missionsName, LocalDate startDate, LocalDate endDate, Long missionsDistance, Spaceship assignedSpaceShift, List<CrewMember> assignedCrew, MissionResult missionResult) {
        super(id, name);
        this.missionsName = missionsName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.missionsDistance = missionsDistance;
        this.assignedSpaceShift = assignedSpaceShift;
        this.assignedCrew = assignedCrew;
        this.missionResult = missionResult;
    }
}
