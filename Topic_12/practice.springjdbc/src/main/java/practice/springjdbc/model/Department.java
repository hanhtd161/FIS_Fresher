package practice.springjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	 private Long deptId;
	 private String deptNo;
	 private String deptName;
	 
}
