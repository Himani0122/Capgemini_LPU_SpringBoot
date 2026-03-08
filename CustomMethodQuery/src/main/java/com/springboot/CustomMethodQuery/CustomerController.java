package com.springboot.CustomMethodQuery;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	@Autowired
	CustomerJpaRepository custom;
	
	@PostMapping("/custom")
	public String getCustomer(@RequestBody Customer c) {
		Customer cus = custom.save(c);
		return cus.toString();
	}
	
	@GetMapping("/findbyid")
	public String getById(@RequestParam int id) {
		Optional<Customer> option = custom.findById(id);
		return option.isPresent()?option.get().toString():"Data does not exist";
	}
	
	@GetMapping("/findall")
	public String getAllid() {
		List<Customer> list = custom.findAll();
		return list.isEmpty()?"Data does not exist":list.toString();
	}
	
	@DeleteMapping("/delete-id/{id}")
	public boolean deletebyid(@PathVariable int id) {
		Optional<Customer> cu = custom.findById(id);
		if(cu.isPresent()) {
			custom.delete(cu.get());
			return true;
		}else {
			return false;
		}
		
	}
}
