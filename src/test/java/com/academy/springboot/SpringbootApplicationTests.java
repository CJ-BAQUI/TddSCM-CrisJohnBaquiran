package com.academy.springboot;

import com.academy.springboot.models.Employees;
import com.academy.springboot.repository.EmployeeRepository;
import com.academy.springboot.services.EmployeeServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class SpringbootApplicationTests {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeServices employeeServices = new EmployeeServices();

	Employees baqui = new Employees(1L, "Baqui", 18, 30000.0, "jr SoftDev");
	Employees haji = new Employees(2L, "Hajime", 19, 40000.0, "Archiect");
	Employees zoro = new Employees(3L, "Zoro", 30, 4000000.0, "Swordsman");
	Employees erza = new Employees(4L, "Erza Scarlet", 27, 3500000.0, "Swordsman");
	List<Employees> employees = List.of(baqui, haji, zoro, erza);

	@BeforeEach
	void setup(){
		Mockito.when(employeeRepository.findAll())
				.thenReturn(employees);
	}

	@Test
	@DisplayName("Check if the h2 Database is not null")
	void testIfNotNull() {

		List<Employees> employeesList = employeeServices.getAllEmployees();

		assertNotNull(employeesList);
	}

	@Test
	@DisplayName("Check if salary is more than the amount")
	void testEmployeeEarningMoreThanAmount() {

		List<Employees> employeesList = employeeServices.getAllEmployeesThatEarningMoreThan(35000.0);

		assertThat(employeesList).contains(haji, zoro, erza);
	}

	@Test
	@DisplayName("Check if age is more than howOld")
	void testEmployeeAgeMoreThanHowOld() {

		List<Employees> employeesList = employeeServices.getAllEmployeesThatHasTheAgeMoreThan(25);

		assertThat(employeesList).contains(zoro, erza);
	}

	@Test
	@DisplayName("Check if the position is equal to")
	void testEmployeeWithPositionEqualsTo() {

		List<Employees> employeesList = employeeServices.getAllEmployeesThatHasThePositionOf("Swordsman");

		assertThat(employeesList).contains(zoro, erza);
	}

	@Test
	@DisplayName("Checks if employee has thw highest salary")
	public void testEmployeeWithTheHighestSalary(){


		Employees employeeList = employeeServices.getEmployeeWithTheHighestSalary();

		assertEquals(employeeList, zoro);
	}


}
