package com.spring.SpringBootTemplate.Repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.spring.SpringBootTemplate.Mapper.Security_User_Mapper;
import com.spring.SpringBootTemplate.Model.Security_User;

@Repository
public class Securty_Repository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// Select ===>> find by user name
	public Security_User findByUserName(String username) {
		
		String sql="select su.id,su.username,su.password,su.enabled,sr.role_name from sec_roles sr join sec_users su on su.role_id = sr.id where su.username =?";
		
		return jdbcTemplate.queryForObject(sql, new Security_User_Mapper(),username);
	}
	
	// Select ==>> get authorities by user id
	public List<String> getAuthoritiesByUserId(Integer userId){
		
		String sql ="select sa.authority_name from sec_users_authorities sua join sec_authorities sa on sa.id = sua.authority_Id where sua.user_id =?";
		
		return jdbcTemplate.query(sql, (rs,rowCount) -> rs.getString("authority_name"),userId);
	}

}
