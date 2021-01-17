package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.criteria.SpaceshipCriteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.service.BaseEntityService;
import com.epam.jwd.core_final.service.CrewService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CrewMemberService extends BaseEntityService<CrewMember> implements CrewService {

    CrewMemberCriteria memberCriteria;

    public CrewMemberService() {
        super(CrewMember.class);
    }

    @Override
    public List<CrewMember> findAllCrewMembers() {

        List<CrewMember> crewMembers = null;

        try {
            crewMembers = new ArrayList<>(super.findAll());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return crewMembers;
    }

    @Override
    public List<CrewMember> findAllCrewMembersByCriteria(Criteria<? extends CrewMember> criteria) {

        memberCriteria = (CrewMemberCriteria) criteria;

        List<CrewMember> allCrewMembers = findAllCrewMembers();

        List<CrewMember> crewMembers = new ArrayList<>();

        if (memberCriteria.getRoleId() != null) {
            crewMembers = allCrewMembers.stream()
                    .filter(crewMember -> crewMember.getRole().getId().equals(memberCriteria.getRoleId()))
                    .collect(Collectors.toList());
        }
        if (memberCriteria.getRankId() != null) {
            crewMembers = allCrewMembers.stream()
                    .filter(crewMember -> crewMember.getRank().getId().equals(memberCriteria.getRankId()))
                    .collect(Collectors.toList());
        }


        return crewMembers;
    }

    @Override
    public Optional<CrewMember> findCrewMemberByCriteria(Criteria<? extends CrewMember> criteria) {

        memberCriteria = (CrewMemberCriteria) criteria;

        List<CrewMember> allCrewMembers = findAllCrewMembers();

        List<CrewMember> crewMembers = new ArrayList<>();

        if (memberCriteria.getId() != null) {
            crewMembers = allCrewMembers.stream()
                    .filter(crewMember -> crewMember.getId().equals(memberCriteria.getId()))
                    .collect(Collectors.toList());
        }

        Optional<CrewMember> crewMember = crewMembers.size() != 0 ? Optional.of(crewMembers.get(0)) : Optional.empty();

        return crewMember;
    }

    public List<CrewMember> choiceCrewMembers(String ids) {
        String[] idArray = ids.split(",");
        List<CrewMember> pilots = new ArrayList<>();

        pilots = Arrays.stream(idArray)
                .mapToLong(Long::parseLong)
                .mapToObj(id -> findCrewMemberByCriteria(CrewMemberCriteria.builder().id(id).build()))
                .map(Optional::get)
                .collect(Collectors.toList());

        return pilots;
    }

   /* private CrewMember cheakCrewMember(String nm) {
        Optional<CrewMember> crewMemberByCriteria = findCrewMemberByCriteria(CrewMemberCriteria.builder().roleId(Long.getLong(nm)).build());

        if ( crewMemberByCriteria.isPresent()){

            CrewMember crewMember = crewMemberByCriteria.get();

        };
        return crewMember;
    }*/

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
