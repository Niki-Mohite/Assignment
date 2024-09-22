package com.nikita.streams;

import java.util.*;
import java.util.stream.Collectors;

	class Employee {
	    String firstName;
	    int joiningYear;

	    Employee(String firstName, int joiningYear) {
	        this.firstName = firstName;
	        this.joiningYear = joiningYear;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public int getJoiningYear() {
	        return joiningYear;
	    }
	}

	public class EmployeesJoined {
	    public static void main(String[] args) {
	        List<Employee> employees = Arrays.asList(
	            new Employee("Nikita", 2023),
	            new Employee("Yashna", 2022),
	            new Employee("Sanj", 2023)
	        );

	        List<String> names = employees.stream()
	            .filter(emp -> emp.getJoiningYear() == 2023)
	            .map(Employee::getFirstName)
	            .collect(Collectors.toList());

	        names.forEach(System.out::println);
	    }
	}


