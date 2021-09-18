package local.systemv.springcloudexam.employee.producer.service;

import local.systemv.springcloudexam.employee.producer.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

	public Mono<Employee> getEmployee(Long empId);
	public Flux<Employee> getEmployee();
}
