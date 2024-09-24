package com.nikita.birds;

public class Parrot extends Bird {
    public Parrot() {
        super("Parrot");
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying.");
    }
}
