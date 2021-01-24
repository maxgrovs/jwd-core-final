package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Rank;
import com.epam.jwd.core_final.domain.Role;

/**
 * Should be a builder for {@link com.epam.jwd.core_final.domain.CrewMember} fields
 */
public class CrewMemberCriteria extends Criteria<CrewMember> {
    private Long id;
    private Long roleId;
    private Long rankId;
    private Boolean isReadyForNextMissions;

    public CrewMemberCriteria(Long id, Long roleId, Long rankId, Boolean isReadyForNextMissions) {
        this.id = id;
        this.roleId = roleId;
        this.rankId = rankId;
        this.isReadyForNextMissions = isReadyForNextMissions;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public Long getRankId() {
        return rankId;
    }

    public Boolean getReadyForNextMissions() {
        return isReadyForNextMissions;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long roleId;
        private Long rankId;
        private Boolean isReadyForNextMissions;


        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder roleId(Long roleId) {
            this.roleId = roleId;
            return this;
        }

        public Builder rankId(Long rankId) {
            this.rankId = rankId;
            return this;
        }

        public Builder isReadyForNextMissions(Boolean isReadyForNextMissions) {
            this.isReadyForNextMissions = isReadyForNextMissions;
            return this;
        }

        public CrewMemberCriteria build() {
            return new CrewMemberCriteria(
                    this.id,
                    this.roleId,
                    this.rankId,
                    this.isReadyForNextMissions
            );

        }

    }
}
