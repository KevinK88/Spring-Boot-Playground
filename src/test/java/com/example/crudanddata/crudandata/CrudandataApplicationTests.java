package com.example.crudanddata.crudandata;

import com.example.crudanddata.crudandata.dao.EmployeRepository;
import com.example.crudanddata.crudandata.entity.Employee;
import com.example.crudanddata.crudandata.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CrudandataApplicationTests {
	@Autowired
	EmployeeService employeeService;
	@MockBean
	EmployeRepository employeeRepository;
	@BeforeEach
	public void setup(){
		Optional<Employee> employee = Optional.of(new Employee(1,"John","Doe","joedoe@test.com"));
		Mockito.when(employeeRepository.findById(1)).thenReturn(employee);
	}
	@Test
	void contextLoads() {
		String employeeFirstName = "John";
		String employeeLastName = "Doe";
		String employeeEmail = "joedoe@test.com";
		Employee byId = employeeService.findById(1);
		assertEquals(employeeFirstName,byId.getFirstName());
	}

}
