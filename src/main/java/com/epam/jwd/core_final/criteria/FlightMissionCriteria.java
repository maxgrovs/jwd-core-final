package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.FlightMission;
import com.epam.jwd.core_final.domain.MissionResult;
import com.epam.jwd.core_final.domain.Spaceship;

import java.time.LocalDate;
import java.util.List;

/**
 * Should be a builder for {@link com.epam.jwd.core_final.domain.FlightMission} fields
 */
public class FlightMissionCriteria extends Criteria<FlightMission> {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long missionsDistance;
    private Spaceship assignedSpaceShift;
    private List<CrewMember> assignedCrew;
    private MissionResult missionResult;

    public FlightMissionCriteria(Long id, LocalDate startDate, LocalDate endDate,
                                 Long missionsDistance, Spaceship assignedSpaceShift,
                                 List<CrewMember> assignedCrew, MissionResult missionResult) {

        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.missionsDistance = missionsDistance;
        this.assignedSpaceShift = assignedSpaceShift;
        this.assignedCrew = assignedCrew;
        this.missionResult = missionResult;
    }

    public FlightMissionCriteria(Long id, LocalDate startDate, LocalDate endDate,
                                 Long missionsDistance, MissionResult missionResult) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.missionsDistance = missionsDistance;
        this.missionResult = missionResult;
    }


    @Override
    public Long getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Long getMissionsDistance() {
        return missionsDistance;
    }

    public Spaceship getAssignedSpaceShift() {
        return assignedSpaceShift;
    }

    public List<CrewMember> getAssignedCrew() {
        return assignedCrew;
    }

    public MissionResult getMissionResult() {
        return missionResult;
    }

    public static FlightMissionCriteria.Builder builder() {
        return new FlightMissionCriteria.Builder();
    }

    public static class Builder {
        private Long id;
        private LocalDate startDate;
        private LocalDate endDate;
        private Long missionsDistance;
        private Spaceship assignedSpaceShift;
        private List<CrewMember> assignedCrew;
        private MissionResult missionResult;

        public Builder id(Long id) {
            this.id = id;

            return this;
        }

        public Builder startDate(String startDate) {
            this.startDate = LocalDate.parse(startDate);
            return this;
        }

        public Builder endDate(String endDate) {
            this.endDate = LocalDate.parse(endDate);
            return this;
        }

        public Builder missionsDistance(Long missionsDistance) {
            this.missionsDistance = missionsDistance;
            return this;
        }

        public Builder missionsDistance(MissionResult missionResult) {
            this.missionResult = missionResult;
            return this;
        }

        public FlightMissionCriteria build() {
            return new FlightMissionCriteria(
                    this.id,
                    this.startDate,
                    this.endDate,
                    this.missionsDistance,
                    this.missionResult
            );
        }
    }
}
