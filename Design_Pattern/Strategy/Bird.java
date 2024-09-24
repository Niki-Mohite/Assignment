package com.nikita.birds;

public abstract class Bird {
    protected String name;

    public Bird(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void fly();
}
