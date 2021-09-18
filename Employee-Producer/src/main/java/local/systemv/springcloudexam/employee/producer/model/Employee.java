package local.systemv.springcloudexam.employee.producer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Employee {

	private Long empId;
	private String name;
	private String description;
	private double salary;
}
