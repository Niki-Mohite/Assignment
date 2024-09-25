package com.nikita.main;

import com.nikita.birds.*;


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    	Crow crow = new Crow.Builder().withName("Crow").build();
        crow.fly();

        Parrot parrot = new Parrot.Builder().withName("Parrot").build();
        parrot.fly();

        Penguin penguin = new Penguin.Builder().withName("Penguin").build();
        System.out.println(penguin.getName() + " can't fly.");
    }

}
