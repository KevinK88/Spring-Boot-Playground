package com.example.crudanddata.crudandata.dao;

import com.example.crudanddata.crudandata.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
