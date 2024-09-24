package com.nikita.birds;

public class Crow extends Bird {
    public Crow() {
        super("Crow");
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying.");
    }
}
