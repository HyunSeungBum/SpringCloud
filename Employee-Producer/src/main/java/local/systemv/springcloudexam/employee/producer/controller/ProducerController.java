package local.systemv.springcloudexam.employee.producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import local.systemv.springcloudexam.employee.producer.model.Employee;
import local.systemv.springcloudexam.employee.producer.service.EmployeeService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProducerController {
	
	private final EmployeeService employeeService;
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage() {
		
		Employee a = employeeService.getEmployee();
		
		return a;
		
	}
}
