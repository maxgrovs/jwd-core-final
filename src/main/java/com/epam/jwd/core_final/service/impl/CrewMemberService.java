package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.context.impl.NassaContext;
import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.service.BaseEntityService;
import com.epam.jwd.core_final.service.CrewService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CrewMemberService extends BaseEntityService<CrewMember> implements CrewService {

    public CrewMemberService() {
        super(CrewMember.class);
    }

    @Override
    public List<CrewMember> findAllCrewMembers() throws IOException {

        return new ArrayList<>(super.findAll());
    }

    @Override
    public List<CrewMember> findAllCrewMembersByCriteria(Criteria<? extends CrewMember> criteria) throws IOException {

        CrewMemberCriteria memberCriteria  = (CrewMemberCriteria) criteria;

        List<CrewMember> allCrewMembers = new ArrayList<>(super.findAll());

        List<CrewMember> crewMemberList = allCrewMembers.stream()
                .filter(crewMember -> crewMember.getRole().getId().equals(memberCriteria.getRoleId()))
                .filter(crewMember -> crewMember.getRank().getId().equals(memberCriteria.getRankId()))
                .collect(Collectors.toList());

        return crewMemberList;
    }

    @Override
    public Optional<CrewMember> findCrewMemberByCriteria(Criteria<? extends CrewMember> criteria) throws IOException {

        /*List<CrewMember> allCrewMembers = findAllCrewMembers();

        allCrewMembers.forEach(System.out::println);*/

        return Optional.empty();
    }

    @Override
    public CrewMember updateCrewMemberDetails(CrewMember crewMember) {
        return null;
    }

    @Override
    public void assignCrewMemberOnMission(CrewMember crewMember) throws RuntimeException {

    }

    @Override
    public CrewMember createCrewMember(CrewMember spaceship) throws RuntimeException {
        return null;
    }
}
