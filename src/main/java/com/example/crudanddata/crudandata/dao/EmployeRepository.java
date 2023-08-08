package com.example.crudanddata.crudandata.dao;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.example.crudanddata.crudandata.entity.Employee;

public interface EmployeRepository extends CosmosRepository<Employee, Integer> {

}
