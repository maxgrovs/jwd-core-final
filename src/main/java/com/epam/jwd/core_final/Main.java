package com.epam.jwd.core_final;

import com.epam.jwd.core_final.context.Application;

import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.exception.InvalidStateException;

import com.epam.jwd.core_final.service.impl.CrewMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, InvalidStateException {
        //  ApplicationMenu start =
        Application.start();


        //  logger.info("hello world!");



    }


}