package com.nikita.fi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

	public class SortedEmployeesByDOB {
	    public static void main(String[] args) {
	    	 List<Employee> employees = createEmployees();

	         
	         employees.sort(Comparator.comparing(Employee::getDateOfBirth));

	         System.out.println("Employees sorted by dateOfBirth:");
	         employees.forEach(System.out::println);
	    }

	private static List<Employee> createEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "Smith", 1, LocalDate.of(1990, 5, 20), 2500, "HR"));
        employees.add(new Employee("Bob", "Johnson", 2, LocalDate.of(1985, 3, 15), 1500, "IT"));
        employees.add(new Employee("Charlie", "Brown", 3, LocalDate.of(1992, 8, 30), 3000, "Finance"));
        employees.add(new Employee("Diana", "White", 4, LocalDate.of(1988, 1, 25), 1800, "Marketing"));
        return employees;
    }
	}



