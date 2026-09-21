package com.spring.SpringBootTemplate.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.spring.SpringBootTemplate.Model.Security_User;
import com.spring.SpringBootTemplate.Repository.Securty_Repository;

@Service
public class Customer_User_Details_Service implements UserDetailsService {
	@Autowired
	private Securty_Repository secRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Security_User obj = secRepo.findByUserName(username);
		
		List<String> authorities = secRepo.getAuthoritiesByUserId(obj.getId());
		
		List<GrantedAuthority> grantAutorities = new ArrayList<>(authorities.stream().map(SimpleGrantedAuthority::new).toList());
		
		grantAutorities.add(new SimpleGrantedAuthority("ROLE_"+obj.getRolerName()));
		
		obj.setAuthorities(grantAutorities);
		System.out.println("obj : " +obj);
		
		return obj;
	}

}
