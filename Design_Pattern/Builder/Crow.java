package com.nikita.birds;

public class Crow extends Bird implements Flyable {
    private Crow(Builder builder) {
        super(builder);
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying.");
    }

    public static class Builder extends Bird.Builder<Builder> {
        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Crow build() {
            return new Crow(this);
        }
    }
}
