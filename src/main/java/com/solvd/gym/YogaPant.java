package com.solvd.gym;

public enum YogaPant {

    PREGNANT("Maternity Yoga Pants"),
    STUDIO("Yoga Shorts"),
    WORKOUT("Workout Pants"),
    FLEXIBLE("Yoga Capris Pants"),
    STRETCHING("High Waist Yoga Pants");

    private final String type;

    YogaPant(String typeOfPant) {
        this.type = typeOfPant;
    }

    public String getType() {
        return type;
    }
}
