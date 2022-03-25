package com.fis.template.exchange.impl;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.fis.template.DTO.AccountDTO;
import com.fis.template.exchange.ExchangeService;

public class ExchangeServiceImpl implements ExchangeService {

	@Override
	public List<AccountDTO> getAllAccount() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/getByFullname/Nguyen";
		restTemplate.exchange(url, HttpMethod.GET, AccountDTO.class);
		return null;
	}

}
