package com.academy.springboot.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
//    @Column(name="employeeName")
    private  String name;
//    @Column(name="employeeAge")
    private  int age;
//    @Column(name="employeeSalary")
    private Double salary;
//    @Column(name = "employeePosition")
    private String position;

    public Employees() {
    }

    public Employees(Long id, String name, int age, Double salary, String position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }
    public Employees(List<String> employeesList){}

    public  String getName() {
        return name;
    }

    public  int getAge() {
        return age;
    }

    public Double getSalary() {
        return salary;
    }

    public  String getPosition() {
        return position;
    }

    public  Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return  "\n id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", position='" + position + '\'';
    }
}
