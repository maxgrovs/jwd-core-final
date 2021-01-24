package com.epam.jwd.core_final.domain;

import com.epam.jwd.core_final.criteria.Criteria;

import java.util.Objects;

/**
 * Expected fields:
 * <p>
 * role {@link Role} - member role
 * rank {@link Rank} - member rank
 * isReadyForNextMissions {@link Boolean} - true by default. Set to false, after first failed mission
 */
public class CrewMember extends AbstractBaseEntity{
    // todo

    private Role role;
    private Rank rank;
    private Boolean isReadyForNextMissions;

    public CrewMember(String name) {
        super(name);
    }

    private CrewMember(String name, Role role, Rank rank) {
        super(name);
        this.role = role;
        this.rank = rank;
        this.isReadyForNextMissions = true;
    }

    public Role getRole() {
        return role;
    }

    public Rank getRank() {
        return rank;
    }

    public Boolean getReadyForNextMissions() {
        return isReadyForNextMissions;
    }

    public void setReadyForNextMissions(Boolean readyForNextMissions) {
        isReadyForNextMissions = readyForNextMissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrewMember that = (CrewMember) o;
        return role == that.role &&
                rank == that.rank &&
                Objects.equals(isReadyForNextMissions, that.isReadyForNextMissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, rank, isReadyForNextMissions);
    }

    @Override
    public String toString() {
        return "CrewMember{" +
                "role=" + role +
                ", rank=" + rank +
                ", isReadyForNextMissions=" + isReadyForNextMissions +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }



    public static class Builder {

        String name;
        Role role;
        Rank rank;
        // Boolean isReadyForNextMissions;


        public Builder id() {

            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder role(Long id) {

            this.role = Role.resolveRoleById(id);
            return this;
        }

        public Builder rank(Long id) {

            this.rank = Rank.resolveRankById(id);
            return this;
        }

       /* public Builder isReadyForNextMissions() {
            this.isReadyForNextMissions = true;
            return this;
        }*/

        public CrewMember build() {
            return new CrewMember(

                    this.name,
                    this.role,
                    this.rank
                    // this.isReadyForNextMissions
            );
        }
    }
}
