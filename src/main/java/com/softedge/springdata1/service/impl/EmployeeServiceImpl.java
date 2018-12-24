package com.softedge.springdata1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softedge.springdata1.exception.EmployeeNotFoundException;
import com.softedge.springdata1.model.Employee;
import com.softedge.springdata1.repository.EmployeeRepository;
import com.softedge.springdata1.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(int employeeId) throws EmployeeNotFoundException {
		 Optional<Employee> employee = employeeRepository.findById(employeeId);
		 if(employee.isPresent())
			 employeeRepository.deleteById(employeeId);
		 else
			 throw new EmployeeNotFoundException("Employee record not found.");
	}

	@Override
	public Employee findById(int employeeId) throws EmployeeNotFoundException {
		 Optional<Employee> employee = employeeRepository.findById(employeeId);
		 if(employee.isPresent())
			return employee.get();
		 else
			throw new EmployeeNotFoundException("Employee record not found.");
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

}
