package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.service.BaseEntityService;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class CrewMemberServiceTest extends BaseEntityService {

    protected CrewMemberServiceTest() {
        super(CrewMember.class);
    }

    @Test
    public void findAllCrewMembers() throws IOException {

        List<CrewMember> all = (List<CrewMember>) super.findAll();
        all.forEach(System.out::println);

    }

    @Test
    public void findAllCrewMembersByCriteria() {
    }

    @Test
    public void findCrewMemberByCriteria() {
    }

    @Test
    public void updateCrewMemberDetails() {
    }

    @Test
    public void assignCrewMemberOnMission() {
    }

    @Test
    public void createCrewMember() {
    }
}