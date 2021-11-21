package com.solvd.gym;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class GymSaxParser {
    public static Gym parse(String xmlPath) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();

        Gym gym = new Gym();

        try {

            SAXParser saxParser = saxFactory.newSAXParser();

            GymSaxHandler handler = new GymSaxHandler();
            saxParser.parse(xmlPath, handler);

            gym = handler.getData();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return gym;
    }
}
