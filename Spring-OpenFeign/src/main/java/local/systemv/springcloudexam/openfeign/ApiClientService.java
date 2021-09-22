package local.systemv.springcloudexam.openfeign;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApiClientService {
	
	private final ApiClient apiClient;

	public String getEmployee(Long empId) {
		return apiClient.getEmployeeId(empId);
	}
	
}
