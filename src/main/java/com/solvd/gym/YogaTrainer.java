package com.solvd.gym;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement(name = "yogaTrainer")
@XmlAccessorType(XmlAccessType.FIELD)
public class YogaTrainer extends Trainer {

    private YogaPant yogaPant;
    private YogaInstrument yogaInstrument;

    public YogaTrainer(String name, LocalDate dob, YogaPant yogaPant, YogaInstrument yogaInstrument) {
        super(name, dob, "Yoga Trainer");
        this.yogaPant = yogaPant;
        this.yogaInstrument = yogaInstrument;
    }

    public YogaPant getYogaPant() {
        return yogaPant;
    }

    public void setYogaPant(YogaPant yogaPant) {
        this.yogaPant = yogaPant;
    }

    public YogaInstrument getYogaInstrument() {
        return yogaInstrument;
    }

    public void setYogaInstrument(YogaInstrument yogaInstrument) {
        this.yogaInstrument = yogaInstrument;
    }

    @Override
    public String toString() {
        return "YogaTrainer{" +
                "yogaPant=" + yogaPant +
                ", yogaInstrument=" + yogaInstrument +
                ", name=" + this.getName() +
                ", dateOfBirth=" + this.getDateOfBirth() +
                '}';
    }
}
