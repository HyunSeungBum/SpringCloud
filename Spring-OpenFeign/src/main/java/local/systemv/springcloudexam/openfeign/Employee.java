package local.systemv.springcloudexam.openfeign;

import java.io.Serializable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2257425705262725850L;
	
	private final Long empId;
	private final String name;
	private final String description;
	private final double salary;
}

