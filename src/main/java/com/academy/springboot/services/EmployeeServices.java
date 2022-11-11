package com.academy.springboot.services;

import com.academy.springboot.models.Employees;
import com.academy.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employees> getAllEmployees() {
        return (List<Employees>) employeeRepository.findAll();
    }

    public List<Employees> getAllEmployeesThatEarningMoreThan(Double amount){
        List<Employees> employeesOptional = (List<Employees>) employeeRepository.findAll();
        return  employeesOptional.stream().filter(employee -> employee.getSalary() > amount)
                .collect(Collectors.toList());
    }

    public List<Employees> getAllEmployeesThatHasTheAgeMoreThan(int howOld){
        List<Employees> employeesOptional = (List<Employees>) employeeRepository.findAll();
        return  employeesOptional.stream().filter(employee -> employee.getAge() > howOld)
                .collect(Collectors.toList());
    }

    public List<Employees> getAllEmployeesThatHasThePositionOf(String title){
        List<Employees> employeesOptional = (List<Employees>) employeeRepository.findAll();
        return  employeesOptional.stream().filter(employee -> Objects.equals(employee.getPosition(), title))
                .collect(Collectors.toList());
    }
    public Employees getEmployeeWithTheHighestSalary(){
        List<Employees> employeesOptional = (List<Employees>) employeeRepository.findAll();
        return employeesOptional.stream().max(Comparator.comparing(Employees::getSalary)).get();
    }

}
