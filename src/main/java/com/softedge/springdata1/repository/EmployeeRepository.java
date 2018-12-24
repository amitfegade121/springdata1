package com.softedge.springdata1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.softedge.springdata1.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

}
