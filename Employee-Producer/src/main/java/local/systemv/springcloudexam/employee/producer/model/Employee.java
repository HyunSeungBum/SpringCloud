package local.systemv.springcloudexam.employee.producer.model;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Employee {

	private String empId;
	private String name;
	private String description;
	private double salary;
}
