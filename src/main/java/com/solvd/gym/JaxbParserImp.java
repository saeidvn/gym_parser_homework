package com.solvd.gym;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

class JaxbParserImpl implements Parsable {

    @Override
    public Gym parse(String path) {

        File xmlFile = new File(path);

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Gym.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            return (Gym) jaxbUnmarshaller.unmarshal(xmlFile);

        } catch (JAXBException e) {
            throw new RuntimeException("Jaxb parser exception." + "\n" + e.getMessage());
        }
    }

}
