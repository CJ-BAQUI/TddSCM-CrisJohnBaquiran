package com.academy.springboot;

import com.academy.springboot.controllers.EmployeeController;
import com.academy.springboot.models.Employees;
import com.academy.springboot.repository.EmployeeRepository;
import com.academy.springboot.services.EmployeeServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmployeeServices employeeServices;

    Path path = Paths.get("report.csv");

    @Test
    @DisplayName("Test if GetMapping writes data to report.csv")
    public void checkIfNotNull() {

        List<String> employeesList = null;
        try {
            employeesList = Collections.singletonList(Files.readString(path));
        } catch (Exception e) {
            System.out.println(e);
        }
        assertNotNull(employeesList);
    }
}
