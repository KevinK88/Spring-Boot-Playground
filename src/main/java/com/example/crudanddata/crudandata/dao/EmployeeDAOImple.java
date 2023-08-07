package com.example.crudanddata.crudandata.dao;

import com.example.crudanddata.crudandata.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImple implements EmployeeDAO {
    // Define field for entity manager
    private EntityManager entityManager;
    // set up constructor injection
    @Autowired
    public EmployeeDAOImple (EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll(){
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        // Get Employee
        Employee theEmployee = entityManager.find(Employee.class,theId);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class,theId);
        entityManager.remove(theEmployee);
    }


}