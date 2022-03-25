package com.fis.spring.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.fis.spring.dao.AccountDAO;
import com.fis.spring.entity.Account;


public class AccountDAOImpl implements AccountDAO {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<Account> getByFullname(String fullname) {
		String sql = "SELECT * FROM  `account` WHERE fullname = :fullname";
		Map params = new HashMap();
		params.put("fullname", fullname);
		return namedParameterJdbcTemplate.query(sql, params,new BeanPropertyRowMapper<>(Account.class));
	}

}
