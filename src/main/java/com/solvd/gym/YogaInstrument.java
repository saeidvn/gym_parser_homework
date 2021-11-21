package com.solvd.gym;

public class YogaInstrument {

    private String name;
    private Type type;

    public enum Type {
        FLUTE("Flutes"), DRUM("Drums"), CHIMES("Chimes");

        private final String type;

        Type(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public YogaInstrument(String name, Type typeOfInstrument) {
        this.name = name;
        this.type = typeOfInstrument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "YogaInstrument{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
