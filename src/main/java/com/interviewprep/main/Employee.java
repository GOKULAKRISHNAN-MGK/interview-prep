package com.interviewprep.main;

public class Employee {
    private String name;
    private int age;
    private double Salary;
    private String dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Employee() {
    }

    public Employee(String name, int age, double salary, String dept) {
        this.name = name;
        this.age = age;
        this.Salary = salary;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", Salary=" + Salary +
                ", Department="+ dept +
                '}';
    }
}
