package com.academy.springboot.repository;

import com.academy.springboot.models.Employees;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employees, Long> {
}