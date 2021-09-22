package local.systemv.springcloudexam.openfeign;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Optional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api")
public class ApiController {

//  일반적인 예제.
//	private final ApiClientService apiClientService;
//
//	@GetMapping("/employee/{empId}")
//	public String getEmployeeId(@PathVariable Long empId) throws JsonMappingException, JsonProcessingException {
//		String employeeStr = apiClientService.getEmployeeId(empId);
//
//		ObjectMapper objectMapper = new ObjectMapper();
//		Employee employee = objectMapper.readValue(employeeStr, Employee.class);
//
//		// return employee.toString();
//		return employeeStr;
//	}
	
	
	private final ApiClient apiClient;
	
	// Optional 을 이용하고, ResponseEntity 를 이용한 예제.
	@GetMapping("/employee/{empId}")
	public ResponseEntity<String> getEmployeeId(@PathVariable final Long empId) {
		String employeeStr = apiClient.getEmployeeId(empId);
		
		//ObjectMapper objectMapper = new ObjectMapper();
		//Employee employee = objectMapper.readValue(employeeStr, Employee.class);
		
		Optional<String> a = Optional.of(employeeStr);
		if(a.isPresent()) {
			return new ResponseEntity<>(a.get(), HttpStatus.OK);
		} else {
			throw new RecordNotFoundException();
		}
	}
	
	// Employee 객체를 이용한 사례.
//	@GetMapping("/employee/{empId}")
//	public ResponseEntity<Employee> getEmployeeId(@PathVariable final Long empId) throws JsonMappingException, JsonProcessingException {
//		String employeeStr = apiClient.getEmployeeId(empId);
//		
//		ObjectMapper objectMapper = new ObjectMapper();
//		Employee employee = objectMapper.readValue(employeeStr, Employee.class);
//		
//		Optional<Employee> a = Optional.of(employee);
//		if(a.isPresent()) {
//			return new ResponseEntity<>(a.get(), HttpStatus.OK);
//		} else {
//			throw new RecordNotFoundException();
//		}
//	}	
	
	@GetMapping("/employee")
	public ResponseEntity<String> getEmployee() {
		
		String employeeStr = apiClient.getEmployee();
		Optional<String> a = Optional.of(employeeStr);
		
		if(a.isPresent()) {
			return new ResponseEntity<>(a.get(), HttpStatus.OK);
		} else {
			throw new RecordNotFoundException();
		}
		
	}
	
}
