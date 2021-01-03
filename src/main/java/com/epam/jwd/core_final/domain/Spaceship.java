package com.epam.jwd.core_final.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * crew {@link Map<Role, Short>}
 * flightDistance {@link Long} - total available flight distance
 * isReadyForNextMissions {@link Boolean} - true by default. Set to false, after first failed mission
 */
public class Spaceship extends AbstractBaseEntity {
    //todo
    Map<Role, Short> crew;
    Long flightDistance;
    Boolean isReadyForNextMissions;

    public Spaceship(String name, Map<Role, Short> crew, Long flightDistance, Boolean isReadyForNextMissions) {
        super(name);
        this.crew = crew;
        this.flightDistance = flightDistance;
        this.isReadyForNextMissions = isReadyForNextMissions;
    }

    public static class Builder {

        String name;
        Long flightDistance;
        Map<Role, Short> crew;


        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder flightDistance(Long flightDistance) {
            this.flightDistance = flightDistance;
            return this;
        }

        public Builder crew(Long id, String count) {

            Map<Role, Short> crew = new HashMap<>();



            this.crew = crew;

            return this;
        }
    }
}
