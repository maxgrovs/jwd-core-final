package com.epam.jwd.core_final.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * crew {@link Map<Role, Short>}
 * flightDistance {@link Long} - total available flight distance
 * isReadyForNextMissions {@link Boolean} - true by default. Set to false, after first failed mission
 */
public class    Spaceship extends AbstractBaseEntity {
    //todo
    Map<Role, Short> crew;
    Long flightDistance;
    Boolean isReadyForNextMissions;

    public Spaceship(String name, Long flightDistance, Map<Role, Short> crew) {
        super(name);
        this.crew = crew;
        this.flightDistance = flightDistance;
        this.isReadyForNextMissions = true;
    }

    public Map<Role, Short> getCrew() {
        return crew;
    }

    public Long getFlightDistance() {
        return flightDistance;
    }

    public Boolean getReadyForNextMissions() {
        return isReadyForNextMissions;
    }

    public void setReadyForNextMissions(Boolean readyForNextMissions) {
        isReadyForNextMissions = readyForNextMissions;
    }

    @Override
    public String toString() {
        return "Spaceship{" +
                "crew=" + crew +
                ", flightDistance=" + flightDistance +
                ", isReadyForNextMissions=" + isReadyForNextMissions +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static Spaceship.Builder builder() {
        return new Spaceship.Builder();
    }

    public static class Builder {

        String name;
        Long flightDistance;
        Map<Role, Short> crew;
        Boolean isReadyForNextMissions;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder flightDistance(Long flightDistance) {
            this.flightDistance = flightDistance;
            return this;
        }

        public Builder crew(String crew) {

            Map<Role, Short> crewMap = new HashMap<>();

            String s1 = crew.substring(1, crew.length() - 1);

            String[] s2 = s1.split(",");

            for (String s3 : s2) {

                String[] data = s3.split(":");

                Long roleId = Long.valueOf(data[0]);
                Short countCrewMember = Short.valueOf(data[1]);

                crewMap.put(Role.resolveRoleById(roleId), countCrewMember);

            }

            this.crew = crewMap;

            return this;
        }

        public Builder isReadyForNextMissions(FlightMission flightMission) {

            boolean isReadyForNextMissions = false;



            this.isReadyForNextMissions = isReadyForNextMissions;
            return this;
        }

        public Spaceship build() {
            return new Spaceship(

                    this.name,
                    this.flightDistance,
                    this.crew
                    // this.isReadyForNextMissions
            );
        }
    }
}
