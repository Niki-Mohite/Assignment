package com.nikita.streams;

import java.util.*;
import java.util.stream.Collectors;

	class Employees {
	    String department;
	    double salary;

	    Employees(String department, double salary) {
	        this.department = department;
	        this.salary = salary;
	    }

	    public String getDepartment() {
	        return department;
	    }

	    public double getSalary() {
	        return salary;
	    }
	}

	public class MultipleOperations {
	    public static void main(String[] args) {
	        List<Employees> employees = Arrays.asList(
	            new Employees("IT", 50000),
	            new Employees("IT", 70000),
	            new Employees("HR", 60000)
	        );

	        String targetDepartment = "IT";

	        OptionalDouble average = employees.stream()
	            .filter(emp -> emp.getDepartment().equals(targetDepartment))
	            .mapToDouble(Employees::getSalary)
	            .average();

	        double min = employees.stream()
	            .filter(emp -> emp.getDepartment().equals(targetDepartment))
	            .mapToDouble(Employees::getSalary)
	            .min().orElse(0);

	        double max = employees.stream()
	            .filter(emp -> emp.getDepartment().equals(targetDepartment))
	            .mapToDouble(Employees::getSalary)
	            .max().orElse(0);

	        double sum = employees.stream()
	            .filter(emp -> emp.getDepartment().equals(targetDepartment))
	            .mapToDouble(Employees::getSalary)
	            .sum();

	        long count = employees.stream()
	            .filter(emp -> emp.getDepartment().equals(targetDepartment))
	            .count();

	        System.out.println("Count of Department: " + count);
	        System.out.println("Min Salary of Employee in particular Deptartment: " + min);
	        System.out.println("Max Salary of Employee in particular Deptartment: " + max);
	        System.out.println("Sum of Salary of an Employee in particular Deptartment: " + sum);
	        System.out.println("Average Salary of Employee in particular Deptartment: " + average.orElse(0));
	    }
	}



