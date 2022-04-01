package com.fis.springtest.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fis.springtest.entity.EmployeeVO;

@Repository
public class EmployeeDAO {

	private Map<Integer, EmployeeVO> DB = new HashMap<>();

	public List<EmployeeVO> getEmployeeList()
	{
		List<EmployeeVO> list = new ArrayList<>();
		if(list.isEmpty()) {
			list.addAll(DB.values());
		}
		return list;
	}

	public EmployeeVO getEmployeeById(int id) {
		return DB.get(id);
	}

	public void addEmployee(EmployeeVO employee) {
		employee.setEmployeeId(DB.keySet().size() + 1);
		DB.put(employee.getEmployeeId(), employee);
	}

	public void updateEmployee(EmployeeVO employee) {
		DB.put(employee.getEmployeeId(), employee);
	}

	public void deleteEmployee(int id) {
		DB.remove(id);
	}
}