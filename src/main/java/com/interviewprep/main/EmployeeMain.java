package com.interviewprep.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Mgk",26, 10000, "Admin");
        Employee employee2 = new Employee("Raja",22, 6000, "Health");
        Employee employee3 = new Employee("Emman",23, 7000, "Admin");
        Employee employee4 = new Employee("Jai",24, 8000, "Security");
        Employee employee5 = new Employee("Karthik",25, 9000, "Health");

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        System.out.println("Employee with 2nd Largest Salary and Age Greater than 24: "+employees.stream()
                .filter(e->e.getAge()>24)
                .sorted(Comparator.comparing(Employee::getSalary)
                        .reversed())
                .skip(1)
                .findFirst());

        System.out.println("Employee with the 2nd Biggest Name: "+employees.stream()
                .sorted(Comparator.comparing((Employee e)->e.getName().length()).reversed())
                .skip(1)
                .findFirst());

        System.out.println("Employees with Salary Greater than 7000: ");
        employees.stream().filter(e->e.getSalary()>7000).forEach(System.out::println);

        System.out.println("Group Employees by Department: ");
        employees.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.toList())).entrySet().forEach(System.out::println);

        System.out.println("Highest Paid in Each Department");
        employees.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparing(Employee::getSalary)))).entrySet().forEach(System.out::println);



    }
}
