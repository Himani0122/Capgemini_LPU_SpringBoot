package com.securitypractice.springsecuritydbconnection.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.securitypractice.springsecuritydbconnection.entity.Account;
import com.securitypractice.springsecuritydbconnection.repo.AccountJpaRepository;

@Service
public class DbDetailsUserService implements UserDetailsService {

	private AccountJpaRepository repo;
	
	
	public DbDetailsUserService(AccountJpaRepository repo) {
		super();
		this.repo = repo;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Account account=repo.findByUsername(username)
		.orElseThrow(()->new RuntimeException("Username not found"));
		List<SimpleGrantedAuthority> auth = new ArrayList();
		auth.add(new SimpleGrantedAuthority(account.getRole()));
		return new User(account.getUsername(),account.getPassword(),auth);
	}

}
