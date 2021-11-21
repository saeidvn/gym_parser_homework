package com.solvd.gym;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String v) {
        return LocalDate.parse(v, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Override
    public String marshal(LocalDate v) {
        return v.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

}
