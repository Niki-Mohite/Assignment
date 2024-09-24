package com.nikita.streams;

import java.util.*;
import java.util.stream.Collectors;

class SalaryIncrements {
    String department;
    double salary;

    SalaryIncrements(String department, double salary) {
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    
    public SalaryIncrements withUpdatedSalary(double newSalary) {
        return new SalaryIncrements(this.department, newSalary);
    }
}

public class IncrementinSalaryUsingMap {
    public static void main(String[] args) {
        List<SalaryIncrements> employees = Arrays.asList(
            new SalaryIncrements("IT", 50000),
            new SalaryIncrements("HR", 60000),
            new SalaryIncrements("IT", 70000)
        );

        String targetDepartment = "IT";

        List<SalaryIncrements> updatedEmployees = employees.stream()
            .map(emp -> emp.getDepartment().equals(targetDepartment) 
                ? emp.withUpdatedSalary(emp.getSalary() * 1.1) 
                : emp)
            .collect(Collectors.toList());

        updatedEmployees.forEach(emp -> 
            System.out.println(emp.getDepartment() + ": " + emp.getSalary()));
    }
}
