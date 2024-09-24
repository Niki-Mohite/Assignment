package com.nikita.birds.mainclass;


	import com.nikita.birds.Bird;
	import com.nikita.birds.BirdFactory;
	import com.nikita.birds.strategies.*;
	import java.util.List;

	public class Main {
	    public static void main(String[] args) {
	        // Bird example
	        Bird crow = BirdFactory.createBird("crow");
	        crow.fly();

	        Bird parrot = BirdFactory.createBird("parrot");
	        parrot.fly();

	        Bird penguin = BirdFactory.createBird("penguin");
	        System.out.println(penguin.getName() + " can't fly.");

	        // Summation example
	        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
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



