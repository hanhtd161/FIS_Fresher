package com.fis.springtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.springtest.dao.EmployeeDAO;
import com.fis.springtest.entity.EmployeeVO;

@Service
public class EmployeeManager
{
	@Autowired
	EmployeeDAO dao;

	public List<EmployeeVO> getEmployeeList() {
		return dao.getEmployeeList();
	}

	public EmployeeVO getEmployeeById(int id) {
		return dao.getEmployeeById(id);
	}

	public void addEmployee(EmployeeVO employee) {
		dao.addEmployee(employee);
	}
}
