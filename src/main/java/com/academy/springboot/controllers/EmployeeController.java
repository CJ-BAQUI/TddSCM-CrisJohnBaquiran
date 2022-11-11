package com.academy.springboot.controllers;

import com.academy.springboot.models.Employees;
import com.academy.springboot.services.EmployeeServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.File;
import java.nio.file.*;
import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;

    Double inputAmount = 35000.0;
    int age =25;
    String position = "Swordsman";

    @GetMapping("/showAll")
    public ResponseEntity<List<Employees>> getAllEmployees() {
        List<Employees> employees = employeeServices.getAllEmployees();
        return new ResponseEntity<List<Employees>>(employees,HttpStatus.OK);
    }
    @GetMapping("/showAll/write")
    public void writeAllEmployees(){
        List<Employees> employees = employeeServices.getAllEmployees();
        String CSVFile = "report.csv";
        File file= new File(CSVFile);
        Path path = Path.of(CSVFile);
        try {
            if (!file.createNewFile()) {
                file.delete();
            }
            file.createNewFile();
            Files.writeString(path, "List of All Employees:" + employees.toString(), StandardOpenOption.WRITE);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @GetMapping("/earningMore")
    public ResponseEntity<List<Employees>> getEmployeesWithSalaryMoreThan() {
        List<Employees> employees = employeeServices.getAllEmployeesThatEarningMoreThan(35000.0);
        return new ResponseEntity<List<Employees>>(employees,HttpStatus.OK);
    }

    @GetMapping("/earningMore/write")
    public void writeEmployeesWithSalaryMoreThan(){

        List<Employees> employees = employeeServices.getAllEmployeesThatEarningMoreThan(inputAmount);
        String CSVFile = "report.csv";
        File file= new File(CSVFile);
        Path path = Path.of(CSVFile);
        try {
            if (!file.createNewFile()) {
                file.delete();
            }
            file.createNewFile();
            Files.writeString(path, "Employees Salary more than "+ inputAmount+":" + employees.toString(), StandardOpenOption.WRITE);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @GetMapping("/olderAge")
    public ResponseEntity<List<Employees>> getEmployeesWithAgeMoreThan() {
        List<Employees> employees = employeeServices.getAllEmployeesThatHasTheAgeMoreThan(age);
        return new ResponseEntity<List<Employees>>(employees,HttpStatus.OK);
    }

    @GetMapping("/olderAge/write")
    public void writeEmployeesThatHasTheAgeMoreThan(){

        List<Employees> employees = employeeServices.getAllEmployeesThatHasTheAgeMoreThan(age);
        String CSVFile = "report.csv";
        File file= new File(CSVFile);
        Path path = Path.of(CSVFile);
        try {
            if (!file.createNewFile()) {
                file.delete();
            }
            file.createNewFile();
            Files.writeString(path, "Employees Older than "+ age +":" + employees.toString(), StandardOpenOption.WRITE);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @GetMapping("/jobTitle")
    public ResponseEntity<List<Employees>> getEmployeePositionEqualsTo() {
        List<Employees> employees = employeeServices.getAllEmployeesThatHasThePositionOf(position);
        return new ResponseEntity<List<Employees>>(employees,HttpStatus.OK);
    }

    @GetMapping("/jobTitle/write")
    public void writeEmployeesPositionEqualsTo(){

        List<Employees> employees = employeeServices.getAllEmployeesThatHasThePositionOf(position);
        String CSVFile = "report.csv";
        File file= new File(CSVFile);
        Path path = Path.of(CSVFile);
        try {
            if (!file.createNewFile()) {
                file.delete();
            }
            file.createNewFile();
            Files.writeString(path, "Employees with the title of "+ position +":" + employees.toString(), StandardOpenOption.WRITE);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @GetMapping("/maxSalary")
    public Employees getEmployeeWithTheHighestSalary() {
        return employeeServices.getEmployeeWithTheHighestSalary();
    }

    @GetMapping("/maxSalary/write")
    public void writeEmployeeWithTheHighestSalary(){

        Employees employees = employeeServices.getEmployeeWithTheHighestSalary();
        String CSVFile = "report.csv";
        File file= new File(CSVFile);
        Path path = Path.of(CSVFile);
        try {
            if (!file.createNewFile()) {
                file.delete();
            }
            file.createNewFile();
            Files.writeString(path, "Employees with the highest Salary: " + employees.toString(), StandardOpenOption.WRITE);
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
