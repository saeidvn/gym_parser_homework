package com.solvd.gym;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "gym")
@XmlAccessorType (XmlAccessType.FIELD)
@JsonIgnoreProperties
public class Gym {

    @XmlElementWrapper(name="trainers")
    @XmlElement(name = "trainer")
    private List<Trainer> trainers;

    @XmlElementWrapper(name="members")
    @XmlElement(name = "member")
    private List<Member> members;

    public Gym(List<Member> members) {
        this.members = members;
    }

    public Gym() {
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Gym{" + '\n' +
                "trainers=" + trainers + '\n' +
                "members=" + members + '\n' +
                '}';
    }
}
