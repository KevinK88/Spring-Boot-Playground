package com.example.crudanddata.crudandata;

import com.example.crudanddata.crudandata.entity.Employee;
import com.example.crudanddata.crudandata.rest.EmployeeRestController;
import com.example.crudanddata.crudandata.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeRestController.class)
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;
    private Employee employee;
    @BeforeEach
    void setup(){
        employee = new Employee(1,"John","Doe","joedoe@test.com");
    }
    @Test
    public void testControllerPost() throws Exception {
        Employee employeeTest = new Employee(1,"John","Doe","joedoe@test.com");
        Mockito.when(employeeService.save(employeeTest)).thenReturn(employeeTest);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"id\": 1,\n" +
                                "    \"firstName\": \"John\",\n" +
                                "    \"lastName\": \"Doe\",\n" +
                                "    \"email\": \"joedoe@test.com\"\n" +
                                "}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
