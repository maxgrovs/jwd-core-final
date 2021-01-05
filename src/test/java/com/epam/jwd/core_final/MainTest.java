package com.epam.jwd.core_final;

import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Role;
import com.epam.jwd.core_final.factory.impl.CrewMemberFactory;
import org.junit.Test;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MainTest {


    @Test
    public void main() throws IOException {

        /*String input = "4,Davey Bentley,2";

        CrewMemberFactory factory = new CrewMemberFactory();

        factory.create(input);*/
//----------------------------------------

        CrewMemberFactory factory = new CrewMemberFactory();

        File resources = Paths.get("src", "resources", "input", "crew").toFile();

//****************************************

           try (BufferedReader reader = new BufferedReader(new FileReader(resources))) {

            List<CrewMember> crewMemberList = Arrays.stream(reader.lines()
                    .collect(Collectors.toList())
                    .get(1).split(";"))
                    .collect(Collectors.toList()).stream()
                    .map(s -> s.split(","))
                    .map(factory::create)
                    .collect(Collectors.toList());
            crewMemberList
                    .forEach(System.out::println);

        }
//****************************************

        /*String keys = "#role,name,rank;role,name,rank;role,name,rank;";
        keys = keys.substring(1);

        String[] membersKeys = keys.split(";");

        String values = "4,Davey Bentley,2;1,Zoe Day,1;3,Petra Potter,4;";

        String[] membersValues = values.split(";");

        List<Map<String, String>> membersMapList = new ArrayList<>();

        for (int i = 0; i < membersKeys.length; i++) {

            String[] keyzz = membersKeys[i].split(",");
            String[] valuezz = membersValues[i].split(",");

            Map<String, String> membersMap = new HashMap<>();
            for (int j = 0; j < keyzz.length; j++) {
                membersMap.put(keyzz[j], valuezz[j]);

            }

            membersMapList.add(membersMap);

        }

          membersMapList.forEach(System.out::println);*/

 //******************************************************



    }
}
