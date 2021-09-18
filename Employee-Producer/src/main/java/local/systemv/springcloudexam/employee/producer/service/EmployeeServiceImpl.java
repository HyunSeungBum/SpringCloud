package local.systemv.springcloudexam.employee.producer.service;

import org.springframework.stereotype.Service;

import local.systemv.springcloudexam.employee.producer.model.Employee;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor 
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Override
	public Mono<Employee> getEmployee(Long empId) {
		// TODO Auto-generated method stub
		return Mono.just(new Employee(empId, "emp1", "manager", 3000));
	}

	@Override
	public Flux<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return Flux.just(
				new Employee(1L, "emp1", "manager", 3000),
				new Employee(2L, "emp2", "manager", 3001),
				new Employee(3L, "emp3", "manager", 3002)
				
				);
	}



}
