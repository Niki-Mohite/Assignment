package com.nikita.fi;

import java.time.LocalDate;

public class Employee {
    private String firstName;
    private String lastName;
    private int id;
    private LocalDate dateOfBirth;
    private double salary;
    private String dept;

    public Employee(String firstName, String lastName, int id, LocalDate dateOfBirth, double salary, String dept) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.dept = dept;
    }

    // Getters and setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getDept() { return dept; }
    public void setDept(String dept) { this.dept = dept; }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, firstName='%s', lastName='%s', dateOfBirth=%s, salary=%.2f, dept='%s'}",
                id, firstName, lastName, dateOfBirth, salary, dept);
    }
}
