package com.example.crudanddata.crudandata.dao;

import com.example.crudanddata.crudandata.entity.Employee;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Repository;

@Repository
public class CosmosEmployeeDAO implements EmployeeDAO {

  private final EmployeRepository employeRepository;

  public CosmosEmployeeDAO(EmployeRepository employeRepository) {
    this.employeRepository = employeRepository;
  }

  @Override
  public List<Employee> findAll() {
    //REF https://www.baeldung.com/java-iterable-to-collection
    return StreamSupport.stream(employeRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @Override
  public Employee findById(int theId) {
    //BEST PRACTICE - fetch by ID and Partition ID -- Can be done next time
    return employeRepository.findById(theId).orElse(null);
  }

  @Override
  public Employee save(Employee theEmployee) {
    return employeRepository.save(theEmployee);
  }

  @Override
  public void deleteById(int theId) {
     employeRepository.deleteById(theId);
  }
}
