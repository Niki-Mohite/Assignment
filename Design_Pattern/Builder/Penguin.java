package com.nikita.birds;

public class Penguin extends Bird {
    private Penguin(Builder builder) {
        super(builder);
    }

    // Penguins can't fly

    public static class Builder extends Bird.Builder<Builder> {
        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Penguin build() {
            return new Penguin(this);
        }
    }
}
