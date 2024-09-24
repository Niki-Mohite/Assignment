package com.nikita.fi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class EmpyeesandUsers {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        List<Employee> employees = createEmployees(); 

        Thread employeeThread = new Thread(() -> {
            System.out.println("Employees:");
            employees.forEach(System.out::println);
        });

      
        Thread userThread = new Thread(() -> {
            Supplier<String> passwordSupplier = () -> {
                StringBuilder password = new StringBuilder(16);
                for (int i = 0; i < 16; i++) {
                    password.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
                }
                return password.toString();
            };

            Function<Employee, User> employeeToUser = employee -> {
                String userName = employee.getFirstName() + employee.getLastName() + employee.getDateOfBirth().getYear() + employee.getId();
                String password = passwordSupplier.get();
                return new User(employee.getId(), userName, password);
            };

            List<User> users = new ArrayList<>();
            for (Employee employee : employees) {
                users.add(employeeToUser.apply(employee));
            }

            System.out.println("Users:");
            users.forEach(System.out::println);
        });

        employeeThread.start();
        userThread.start();


    }

    private static List<Employee> createEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Nikita", "Mohite", 1, LocalDate.of(1990, 5, 20), 2500, "HR"));
        employees.add(new Employee("Sanj", "Ghotikar", 2, LocalDate.of(1985, 3, 15), 1500, "IT"));
        employees.add(new Employee("Madhura", "Sukhtankar", 3, LocalDate.of(1992, 8, 30), 3000, "Finance"));
        employees.add(new Employee("Pallavi", "Vhanlakar", 4, LocalDate.of(1988, 1, 25), 1800, "Marketing"));
        return employees;
    }
}
