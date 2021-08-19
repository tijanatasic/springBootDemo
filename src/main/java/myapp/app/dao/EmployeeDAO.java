package myapp.app.dao;

import java.util.List;

import myapp.app.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();
	Employee findById(int id);
	void deleteById(int id);
	void saveEmployee(Employee employee);
	
}
