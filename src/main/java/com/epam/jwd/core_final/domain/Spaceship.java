package com.epam.jwd.core_final.domain;

import java.util.Map;

/**
 * crew {@link java.util.Map<Role, Short>}
 * flightDistance {@link Long} - total available flight distance
 * isReadyForNextMissions {@link Boolean} - true by default. Set to false, after first failed mission
 */
public class Spaceship extends AbstractBaseEntity {
    //todo
    Map<Role, Short> crew;
    Long flightDistance;
    Boolean isReadyForNextMissions;

    public Spaceship(Long id, String name, Map<Role, Short> crew, Long flightDistance, Boolean isReadyForNextMissions) {
        super(id, name);
        this.crew = crew;
        this.flightDistance = flightDistance;
        this.isReadyForNextMissions = isReadyForNextMissions;
    }
}
