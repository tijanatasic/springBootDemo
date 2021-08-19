package myapp.app.service;

import java.util.List;

import myapp.app.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	Employee findById(int id);
	void deleteById(int id);
	void saveEmployee(Employee employee);
	
}
