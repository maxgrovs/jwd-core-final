package com.epam.jwd.core_final;


import com.epam.jwd.core_final.context.impl.NasaContext;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.exception.InvalidStateException;
import com.epam.jwd.core_final.service.impl.CrewMemberService;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class MainTest {


    @Test
    public void main() throws IOException, InvalidStateException {


        final NasaContext nassaContext = NasaContext.getInstance();

        nassaContext.init();


        CrewMemberService  service = new CrewMemberService();

        List<CrewMember> allCrewMembers = service.findAllCrewMembers();

        allCrewMembers.forEach(System.out::println);


    }


}

