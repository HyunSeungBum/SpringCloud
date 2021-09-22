package local.systemv.springcloudexam.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="EMPLOYEE-PRODUCER")
public interface ApiClient {

	@RequestMapping(method=RequestMethod.GET, value="/employee/{empId}", produces = "application/json")
	public String getEmployeeId(@PathVariable Long empId);
	
	@RequestMapping(method=RequestMethod.GET, value="/employee", produces = "application/json")
	public String getEmployee();
}
