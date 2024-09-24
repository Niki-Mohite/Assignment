package com.nikita.birds;

public class Penguin extends Bird {
    public Penguin() {
        super("Penguin");
    }

    @Override
    public void fly() {
        System.out.println(name + " can't fly.");
    }
}
