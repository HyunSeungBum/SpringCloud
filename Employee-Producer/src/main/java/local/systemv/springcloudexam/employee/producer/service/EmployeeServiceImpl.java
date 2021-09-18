package local.systemv.springcloudexam.employee.producer.service;

import org.springframework.stereotype.Service;

import local.systemv.springcloudexam.employee.producer.model.Employee;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public Employee getEmployee() {
		
		Employee employee = Employee.builder()
				.empId("1")
				.description("manager")
				.name("emp1")
				.salary(3000)
				.build();
		
		return employee;
	}

}
