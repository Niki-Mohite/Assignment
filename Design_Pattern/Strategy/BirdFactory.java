package com.nikita.birds;

public class BirdFactory {
    public static Bird createBird(String type) {
        switch (type.toLowerCase()) {
            case "crow":
                return new Crow();
            case "parrot":
                return new Parrot();
            case "penguin":
                return new Penguin();
            default:
                throw new IllegalArgumentException("Unknown bird type");
        }
    }
}
