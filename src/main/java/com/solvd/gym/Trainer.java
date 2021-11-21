package com.solvd.gym;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement(name = "trainer")
@XmlAccessorType (XmlAccessType.FIELD)
public class Trainer {
    private String name;

    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement(name = "dateOfBirth")
    private LocalDate dateOfBirth;
    private String type;

    public Trainer(String name, LocalDate dateOfBirth, String typeOfTrainer) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.type = typeOfTrainer;
    }

    public Trainer () {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", type='" + type + '\'' +
                '}';
    }
}
