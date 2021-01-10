package com.epam.jwd.core_final.domain;

import java.time.LocalDate;
import java.util.List;

/**
 * Expected fields:
 * <p>
 * missions name {@link String}
 * start date {@link LocalDate}
 * end date {@link LocalDate}
 * distance {@link Long} - missions distance
 * assignedSpaceShift {@link Spaceship} - not defined by default
 * assignedCrew {@link List<CrewMember>} - list of missions members based on ship capacity - not defined by default
 * missionResult {@link MissionResult}
 */
public class FlightMission extends AbstractBaseEntity {
    // todo

    LocalDate startDate;
    LocalDate endDate;
    Long missionsDistance;
    Spaceship assignedSpaceShift;
    List<CrewMember> assignedCrew;
    MissionResult missionResult;

    public FlightMission(String name, LocalDate startDate, LocalDate endDate, Long missionsDistance, Spaceship assignedSpaceShift, List<CrewMember> assignedCrew, MissionResult missionResult) {
        super(name);
        this.startDate = startDate;
        this.endDate = endDate;
        this.missionsDistance = missionsDistance;
        this.assignedSpaceShift = assignedSpaceShift;
        this.assignedCrew = assignedCrew;
        this.missionResult = missionResult;
    }

    public static FlightMission.Builder builder() {
        return new FlightMission.Builder();
    }

    public static class Builder {
        String name;
        LocalDate startDate;
        LocalDate endDate;
        Long missionsDistance;
        Spaceship assignedSpaceShift;
        List<CrewMember> assignedCrew;
        MissionResult missionResult;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder missionsDistance(Long missionsDistance) {
            this.missionsDistance = missionsDistance;
            return this;
        }

        public Builder assignedSpaceShift(Spaceship assignedSpaceShift) {
            this.assignedSpaceShift = assignedSpaceShift;
            return this;
        }

        public Builder assignedCrew(List<CrewMember> assignedCrew) {
            this.assignedCrew = assignedCrew;
            return this;
        }

        public Builder missionResult(MissionResult missionResult) {
            this.missionResult = missionResult;
            return this;
        }

        public FlightMission build() {
            return new FlightMission(

                    this.name,
                    this.startDate,
                    this.endDate,
                    this.missionsDistance,
                    this.assignedSpaceShift,
                    this.assignedCrew,
                    this.missionResult
            );
        }
    }
}