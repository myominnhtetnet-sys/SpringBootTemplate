package com.spring.SpringBootTemplate.Model;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Security_User implements UserDetails {
	
	private Integer id;
	private String username;
	private String password;
	private boolean enabled;
	private String rolerName;
	private List<GrantedAuthority> authorities;

}
