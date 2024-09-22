package com.nikita.fi;


	import java.time.LocalDate;
	import java.util.*;
	import java.util.function.Consumer;
	import java.util.stream.Collectors;
	import java.util.function.BiPredicate;

	public class CustomandPredicate {

	    public static void main(String[] args) {

	        List<Employee> employees = Arrays.asList(
	            new Employee("John", "Doe", 1, LocalDate.of(1990, 1, 1), 2500, "IT"),
	            new Employee("Jane", "Smith", 2, LocalDate.of(1985, 5, 15), 1800, "HR"),
	            new Employee("Alice", "Johnson", 3, LocalDate.of(1992, 7, 30), 2200, "Finance"),
	            new Employee("Bob", "Brown", 4, LocalDate.of(1980, 3, 10), 1500, "Admin")
	        );


	        Consumer<Employee> printEmployee = employee -> System.out.println(employees);


	        System.out.println("Employees with salary above 2000:");
	        employees.stream()
	                 .filter(employee -> employee.getSalary() > 2000)
	                 .forEach(printEmployee);
	        
	        BiPredicate<Employee, Double> isSalaryAbove = (employee, threshold) -> employee.getSalary() > threshold;

	        double salaryThreshold = 2000;
	        System.out.println("Employees with salary above " + salaryThreshold + ":");
	        employees.stream()
	                 .filter(employee -> isSalaryAbove.test(employee, salaryThreshold))
	                 .forEach(System.out::println);

	    }
	}


