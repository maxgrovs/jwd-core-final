package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Rank;
import com.epam.jwd.core_final.domain.Role;

/**
 * Should be a builder for {@link com.epam.jwd.core_final.domain.CrewMember} fields
 */
public class CrewMemberCriteria extends Criteria<CrewMember> {

    private Long roleId;
    private Long rankId;
    private Boolean isReadyForNextMissions;

    public CrewMemberCriteria(Long roleId, Long rankId) {
        this.roleId = roleId;
        this.rankId = rankId;
        //this.isReadyForNextMissions = isReadyForNextMissions;
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

        private Long roleId;
        private Long rankId;
        // private Boolean isReadyForNextMissions;

        public Builder roleId(Long roleId) {
            this.roleId = roleId;
            return this;
        }

        public Builder rankId(Long rankId) {
            this.rankId = rankId;
            return this;
        }

        public CrewMemberCriteria build() {
            return new CrewMemberCriteria(

                    this.roleId,
                    this.rankId
                    // this.isReadyForNextMissions
            );

        }

    }
}
