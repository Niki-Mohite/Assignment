package com.nikita.streams;

import java.util.*;
import java.util.stream.Collectors;

	class SortEmployee {
	    String firstName;
	    String department;

	    SortEmployee(String firstName, String department) {
	        this.firstName = firstName;
	        this.department = department;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public String getDepartment() {
	        return department;
	    }
	}

	public class SorteEmpExceptHR {
	    public static void main(String[] args) {
	        List<SortEmployee> employees = Arrays.asList(
	            new SortEmployee("Nikita", "IT"),
	            new SortEmployee("Yashna", "HR"),
	            new SortEmployee("Sanj", "IT"),
	            new SortEmployee("Madhura", "Finance")
	        );

	        List<String> sortedNames = employees.stream()
	            .filter(emp -> !emp.getDepartment().equals("HR"))
	            .map(SortEmployee::getFirstName)
	            .sorted()
	            .collect(Collectors.toList());

	        sortedNames.forEach(System.out::println);
	    }
	}


