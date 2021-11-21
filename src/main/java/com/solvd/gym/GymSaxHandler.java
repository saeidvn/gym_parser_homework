package com.solvd.gym;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Stack;

public class GymSaxHandler extends DefaultHandler implements Parsable {

    private Gym gym;

    private Member member = null;
    private ArrayList<Member> members = new ArrayList();

    private YogaTrainer yogaTrainer = null;
    private ArrayList<Trainer> trainers = new ArrayList();
    private YogaInstrument yogaInstrument = null;
    private Trainer trainer = null;

    private StringBuilder currentValue = new StringBuilder();

    private Stack<String> stack = new Stack<String>();

    @Override
    public Gym parse(String path) {
        return null;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        this.gym = new Gym();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        this.stack.push(qName);

        currentValue.setLength(0);

        switch (qName) {
            case "member":
                int id = Integer.parseInt(attributes.getValue("id"));
                this.member = new Member(null, id);
                break;
            case "yogaTrainer":
                this.yogaTrainer = new YogaTrainer(null, null, null, null);
                break;
            case "yogaInstrument":
                this.yogaInstrument = new YogaInstrument(null, null);
                break;
            case "trainer":
                this.trainer = new Trainer(null, null, null);
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        this.currentValue.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        this.stack.pop();

        String parent = this.stack.empty() ? null : this.stack.peek();

        switch (qName) {
            case "name":
                if(parent.equals("member")) {
                    this.member.setName(this.currentValue.toString());
                }

                if(parent.equals("yogaTrainer")) {
                    this.yogaTrainer.setName(this.currentValue.toString());
                }

                if(parent.equals("yogaInstrument")) {
                    this.yogaInstrument.setName(this.currentValue.toString());
                }

                if(parent.equals("trainer")) {
                    this.trainer.setName(this.currentValue.toString());
                }

                break;
            case "dateOfBirth":
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
                LocalDate date = LocalDate.parse(this.currentValue.toString(), formatter);

                if(parent.equals("yogaTrainer")) {
                    this.yogaTrainer.setDateOfBirth(date);
                }

                if(parent.equals("trainer")) {
                    this.trainer.setDateOfBirth(date);
                }
                break;
            case "yogaPant":
                switch (this.currentValue.toString()) {
                    case "WORKOUT":
                        this.yogaTrainer.setYogaPant(YogaPant.WORKOUT);
                        break;
                    case "PREGNANT":
                        this.yogaTrainer.setYogaPant(YogaPant.PREGNANT);
                        break;
                    case "STUDIO":
                        this.yogaTrainer.setYogaPant(YogaPant.STUDIO);
                        break;
                    case "FLEXIBLE":
                        this.yogaTrainer.setYogaPant(YogaPant.FLEXIBLE);
                        break;
                    case "STRETCHING":
                        this.yogaTrainer.setYogaPant(YogaPant.STRETCHING);
                        break;
                }
                break;
            case "type":
                if(parent.equals("yogaInstrument")) {
                    switch (this.currentValue.toString()) {
                        case "DRUM":
                            this.yogaInstrument.setType(YogaInstrument.Type.DRUM);
                            break;
                        case "FLUTE":
                            this.yogaInstrument.setType(YogaInstrument.Type.FLUTE);
                            break;
                        case "CHIMES":
                            this.yogaInstrument.setType(YogaInstrument.Type.CHIMES);
                            break;
                    }
                }

                if(parent.equals("trainer")) {
                    this.trainer.setType(this.currentValue.toString());
                }

                break;
            case "member":
                this.members.add(this.member);
                this.member = null;
                break;
            case "yogaTrainer":
                this.trainers.add(this.yogaTrainer);
                this.yogaTrainer = null;
                break;
            case "trainer":
                this.trainers.add(this.trainer);
                this.trainer = null;
                break;
            case "yogaInstrument":
                this.yogaTrainer.setYogaInstrument(this.yogaInstrument);
                this.yogaInstrument = null;
                break;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();

        this.gym.setMembers(this.members);
        this.gym.setTrainers(this.trainers);
    }

    public Gym getData() {
        return this.gym;
    }

}
