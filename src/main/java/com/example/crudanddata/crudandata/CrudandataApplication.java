package com.example.crudanddata.crudandata;

import com.example.crudanddata.crudandata.dao.EmployeeDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudandataApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrudandataApplication.class, args);
	}
}
