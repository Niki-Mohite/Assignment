package com.nikita.birds;

public abstract class Bird {
    protected String name;

    protected Bird(Builder<?> builder) {
        this.name = builder.name;
    }

    public String getName() {
        return name;
    }

    public static abstract class Builder<T extends Builder<T>> {
        protected String name;

        public T withName(String name) {
            this.name = name;
            return self();
        }

        protected abstract T self();

        public abstract Bird build();
    }
}
