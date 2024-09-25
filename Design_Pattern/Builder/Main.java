package com.nikita.main;

import com.nikita.birds.*;
import com.nikita.birds.strategies.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Bird example using Builder Pattern
    	Crow crow = new Crow.Builder().withName("Crow").build();
        crow.fly();

        Parrot parrot = new Parrot.Builder().withName("Parrot").build();
        parrot.fly();

        Penguin penguin = new Penguin.Builder().withName("Penguin").build();
        System.out.println(penguin.getName() + " can't fly.");
        
        // Summation example
        List<Integer> numbers = Arrays.asList(12,31,65,90,23);
        SumContext context = new SumContext();

        // Sum all numbers
        context.setStrategy(new SumAllStrategy());
        System.out.println("Sum All: " + context.executeStrategy(numbers));

        // Sum odd numbers
        context.setStrategy(new SumOddStrategy());
        System.out.println("Sum Odd: " + context.executeStrategy(numbers));

        // Sum even numbers
        context.setStrategy(new SumEvenStrategy());
        System.out.println("Sum Even: " + context.executeStrategy(numbers));

        // Sum prime numbers
        context.setStrategy(new SumPrimeStrategy());
        System.out.println("Sum Prime: " + context.executeStrategy(numbers));
    }
}
