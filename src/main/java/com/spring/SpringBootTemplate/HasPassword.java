package com.spring.SpringBootTemplate;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HasPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		System.out.println(encoder.encode("M123"));
		System.out.println(encoder.encode("S123"));
		System.out.println(encoder.encode("A123"));

	}

}
