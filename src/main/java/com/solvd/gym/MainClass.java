package com.solvd.gym;

import javax.swing.text.html.parser.Parser;

import static com.solvd.gym.GymSaxParser.parse;

public class MainClass {
    public static void main(String[] args) {

        String xmlPath = "src/main/resources/gym.xml";

        GymJaxbParser jaxbParser = new GymJaxbParser();
        Gym jaxbOutput = jaxbParser.parse(xmlPath);
        System.out.println(jaxbOutput);

        Gym gymSaxParserResult = GymSaxParser.parse(xmlPath);
        System.out.println(gymSaxParserResult);

    }
}