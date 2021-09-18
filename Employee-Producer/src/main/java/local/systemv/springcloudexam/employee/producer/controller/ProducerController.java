package local.systemv.springcloudexam.employee.producer.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import local.systemv.springcloudexam.employee.producer.model.Employee;
import local.systemv.springcloudexam.employee.producer.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProducerController {
	
	private final EmployeeService employeeService;
	
	@GetMapping("/employee/{empId}")
	public Mono<Employee> getEmployee(@PathVariable Long empId, final ServerHttpRequest request) {
		
		log.info("Employee empId: {}", empId);
		final HttpHeaders httpHeader = request.getHeaders();
		httpHeader.forEach((key, values) -> log.info("{}, {}", key, values));
		
		return employeeService.getEmployee(empId);
	}
	
	@GetMapping("/employee")
	public Flux<Employee> getEmployee() {
		return employeeService.getEmployee();
	}
}
