package com.solvd.gym;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.logging.LogManager;

@XmlRootElement(name = "member")
@XmlAccessorType (XmlAccessType.FIELD)
public class Member {

    private static final LogManager LOGGER = LogManager.getLogManager();

    @XmlAttribute()
    private Integer id;
    private String name;

    public Member(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Member () {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}