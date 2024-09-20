package com.nikita.fi;

import java.time.LocalDate;

@FunctionalInterface
interface CustomUserName {

	    String generate(String firstName, String lastName, int yearOfBirth, int id);
	}

	public class UserNameGenerator {
	    public static void main(String[] args) {
	    	CustomUserName userNameGenerator = (firstName, lastName, yearOfBirth, id) ->
	                firstName + lastName + yearOfBirth + id;

	       
	        String userName = userNameGenerator.generate("Alice", "Smith", 1990, 1);
	        String userName1 = userNameGenerator.generate("Bob", "Johnson", 1985,2);
	        String userName2 = userNameGenerator.generate("Charlie", "Brown", 1992, 3);
	        String userName3 = userNameGenerator.generate("Diana", "White", 1988, 4);
	        System.out.println("Generated UserName: " + userName);
	        System.out.println("Generated UserName: " + userName1);
	        System.out.println("Generated UserName: " + userName2);
	        System.out.println("Generated UserName: " + userName3);
	    }
	}


