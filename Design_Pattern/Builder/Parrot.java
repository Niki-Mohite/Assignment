package com.nikita.birds;

public class Parrot extends Bird implements Flyable {
    private Parrot(Builder builder) {
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
        public Parrot build() {
            return new Parrot(this);
        }
    }
}
