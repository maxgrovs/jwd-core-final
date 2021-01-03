package com.epam.jwd.core_final;

import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.factory.impl.CrewMemberFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        //--Application.start();






        //--------------------------------------------------

        Map<Long, Short> crew = new HashMap<>();

        crew.put(4L, Short.valueOf("3"));

        Map<String, Object> spaceShip = new HashMap<>();

        spaceShip.put("name", "atlantic");
        spaceShip.put("distance", 23453);
        spaceShip.put("crew", crew);

        List value = new ArrayList(spaceShip.values());

        value.forEach(System.out::println);


        String input = "#name;distance;crew {roleid:count,roleid:count,roleid:count,roleid:count}";

        String[] strings = input.split(";");

        for (String command : strings) {

          switch (command){
              case ("#name"):



          }



        }

        //System.out.println(input.substring(1));

        //------------------------------------------------

    }
}