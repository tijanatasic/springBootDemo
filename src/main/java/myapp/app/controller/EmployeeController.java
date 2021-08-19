package myapp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import myapp.app.entity.Employee;
import myapp.app.service.EmployeeService;

@Controller
public class EmployeeController {
	
	EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/custom")
	public String getCustom() {
		return "This is a custom page";
	}
	
	@GetMapping("/employees")
	public String getEmployees(Model model) {
		
		List<Employee> employees=employeeService.findAll();
		model.addAttribute("employees",employees);
		
		return "employees/employees";
	}
	
	@GetMapping("/employeeForm")
	public String getEmployeeForm(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee",employee);
		return "employees/employee-form";
	}
	
	@GetMapping("/employeeDelete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {

		employeeService.deleteById(id);
		
		return "redirect:/employees";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employeeFormUpdate")
	public String update(@RequestParam("employeeId") int employeeId, Model model) {
		Employee employee=employeeService.findById(employeeId);
		model.addAttribute("employee",employee);
		return "employees/employee-form";
	}
	
	
}
