package com.example.crudanddata.crudandata.rest;

import com.example.crudanddata.crudandata.dao.EmployeeDAO;
import com.example.crudanddata.crudandata.entity.Employee;
import com.example.crudanddata.crudandata.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api")
@RestController
public class EmployeeRestController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if (employee == null){
            throw new RuntimeException("Employee id not found " + employee);
        }
        return employee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        // Set to 0 in case users pass in JSON
        employee.setId(0);
        Employee newEmployee = employeeService.save(employee);
        return newEmployee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        // Set to 0 in case users pass in JSON
        Employee newEmployee = employeeService.save(employee);
        return newEmployee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
        // Set to 0 in case users pass in JSON
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee id is not found" + employeeId);
        }
         employeeService.deleteById(employeeId);
    }
    @GetMapping("/test")
    public String test() throws IOException {
        String url = "https://catfact.ninja/fact";
        WebClient.Builder builder = WebClient.builder();
        String response = builder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return response;
    }
}
