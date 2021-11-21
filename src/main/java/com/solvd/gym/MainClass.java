package com.solvd.gym;

public class MainClass {
    public static void main(String[] args) {

        String xmlPath = "src/main/resources/gym.xml";
        String pathJson = "src/main/resources/gym2.json";

        Gym gymSaxParserResult = GymSaxParser.parse(xmlPath);
        System.out.println(gymSaxParserResult);

        GymJaxbParser jaxbParser = new GymJaxbParser();
        Gym jaxbOutput = jaxbParser.parse(xmlPath);
        System.out.println(jaxbOutput);

        GymJacksonParser jacksonParser = new GymJacksonParser();
        Gym jacksonOutput = jacksonParser.parse(pathJson);
        System.out.println(jacksonOutput);

    }
}