package com.nikita.streams;

import java.util.*;
import java.util.stream.Collectors;

	class SalaryIncrement {
	    String department;
	    double salary;

	    SalaryIncrement(String department, double salary) {
	        this.department = department;
	        this.salary = salary;
	    }

	    public String getDepartment() {
	        return department;
	    }

	    public double getSalary() {
	        return salary;
	    }

	    public void setSalary(double salary) {
	        this.salary = salary;
	    }
	}

	public class IncrementInParticularDept {
	    public static void main(String[] args) {
	        List<SalaryIncrement> employees = Arrays.asList(
	            new SalaryIncrement("IT", 50000),
	            new SalaryIncrement("HR", 60000),
	            new SalaryIncrement("IT", 70000)
	        );

	        String targetDepartment = "IT";

	        employees.stream()
	            .filter(emp -> emp.getDepartment().equals(targetDepartment))
	            .forEach(emp -> emp.setSalary(emp.getSalary() * 1.1));

	        employees.forEach(emp -> 
	            System.out.println(emp.getDepartment() + ": " + emp.getSalary()));
	    }
	}



