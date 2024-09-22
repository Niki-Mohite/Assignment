package com.nikita.streams;


import java.util.*;
import java.util.stream.Collectors;

	class SortedEmployeeaccDOB {
	    String firstName;
	    String dateOfBirth; 

	    SortedEmployeeaccDOB(String firstName, String dateOfBirth) {
	        this.firstName = firstName;
	        this.dateOfBirth = dateOfBirth;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public String getDateOfBirth() {
	        return dateOfBirth;
	    }
	}

	public class SeperateFNaccToDOB {
	    public static void main(String[] args) {
	        List<SortedEmployeeaccDOB> employees = Arrays.asList(
	            new SortedEmployeeaccDOB("Nikita", "1999-02-04"),
	            new SortedEmployeeaccDOB("Sanj", "1998-04-25"),
	            new SortedEmployeeaccDOB("Madhura", "1999-09-08")
	        );

	        String result = employees.stream()
	                .sorted(Comparator.comparing(SortedEmployeeaccDOB::getDateOfBirth))
	                .map(SortedEmployeeaccDOB::getFirstName)
	                .collect(Collectors.joining(", "));

	        System.out.println(result);
	    }
	}


