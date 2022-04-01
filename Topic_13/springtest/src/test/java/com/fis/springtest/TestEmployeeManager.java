package com.fis.springtest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.fis.springtest.dao.EmployeeDAO;
import com.fis.springtest.entity.EmployeeVO;
import com.fis.springtest.service.EmployeeManager;

@SpringBootTest
public class TestEmployeeManager {
	@InjectMocks
	EmployeeManager manager;
	
	@Mock
	EmployeeDAO dao;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void getAllEmployeesTest()
	{
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		EmployeeVO empOne = new EmployeeVO(1, "John", "John", "howtodoinjava@gmail.com");
		EmployeeVO empTwo = new EmployeeVO(2, "Alex", "kolenchiski", "alexk@yahoo.com");
		EmployeeVO empThree = new EmployeeVO(3, "Steve", "Waugh", "swaugh@gmail.com");

		list.add(empOne);
		list.add(empTwo);
		list.add(empThree);

		when(dao.getEmployeeList()).thenReturn(list);

		//test
		List<EmployeeVO> empList = manager.getEmployeeList();

		assertEquals(3, empList.size());
		verify(dao, times(1)).getEmployeeList();
	}
	
	@Test
	public void getEmployeeByIdTest()
	{
		when(dao.getEmployeeById(1)).thenReturn(new EmployeeVO(1,"Lokesh","Gupta","user@email.com"));

		EmployeeVO emp = manager.getEmployeeById(1);

		assertEquals("Lokesh", emp.getFirstName());
		assertEquals("Gupta", emp.getLastName());
		assertEquals("user@email.com", emp.getEmail());
	}
	
	@Test
	public void createEmployeeTest()
	{
		EmployeeVO emp = new EmployeeVO(1,"Lokesh","Gupta","user@email.com");

		manager.addEmployee(emp);

		verify(dao, times(1)).addEmployee(emp);
	}
}
