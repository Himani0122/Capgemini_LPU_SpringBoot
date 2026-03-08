package com.securitypractice.springsecuritydbconnection.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.securitypractice.springsecuritydbconnection.dto.AccountRequestDTO;
import com.securitypractice.springsecuritydbconnection.dto.AccountResponseDTO;
import com.securitypractice.springsecuritydbconnection.service.AccountService;

@RestController
public class AccountController {

	private AccountService service;
	
	public AccountController(AccountService service) {
		super();
		this.service = service;
	}



	@PostMapping("/public")
	public AccountResponseDTO create(@RequestBody AccountRequestDTO dto) {
		return service.createAccount(dto);
	}
}
