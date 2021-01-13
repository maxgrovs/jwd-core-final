package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.domain.Role;
import com.epam.jwd.core_final.domain.Spaceship;

import java.util.HashMap;
import java.util.Map;

/**
 * Should be a builder for {@link Spaceship} fields
 */
public class SpaceshipCriteria extends Criteria<Spaceship> {

    private Long id;
    private Map<Role, Short> crew;
    private Long flightDistance;
    private Boolean isReadyForNextMissions;

    public SpaceshipCriteria(Map<Role, Short> crew, Long flightDistance, Long id) {
        this.crew = crew;
        this.flightDistance = flightDistance;
        this.id = id;
        //this.isReadyForNextMissions = isReadyForNextMissions;
    }

    public Map<Role, Short> getCrew() {
        return crew;
    }

    public Long getFlightDistance() {
        return flightDistance;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Boolean getReadyForNextMissions() {
        return isReadyForNextMissions;
    }

    public static SpaceshipCriteria.Builder builder() {
        return new SpaceshipCriteria.Builder();
    }

    public static class Builder {

        private Long id;
        private Map<Role, Short> crew;
        private Long flightDistance;

        public Builder crew(String roleId, String countCrewMember) {

            Map<Role, Short> crewMap = new HashMap<>();

            crewMap.put(Role.resolveRoleById(Long.valueOf(roleId)), Short.valueOf(countCrewMember));

            this.crew = crewMap;

            return this;
        }

        public Builder flightDistance(Long flightDistance) {
            this.flightDistance = flightDistance;

            return this;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public SpaceshipCriteria build() {
            return new SpaceshipCriteria(
                    this.crew,
                    this.flightDistance,
                    this.id

            );

        }

    }
}
