package com.spring.SpringBootTemplate.Repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.spring.SpringBootTemplate.Mapper.User_Row_Mapper;
import com.spring.SpringBootTemplate.Model.User_Bean;

@Repository
public class User_Repository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// Insert user data into the database
	public int insertUser(User_Bean user) {
		int i =0;
		String sql = "insert into user_table(name,email,ph_NO,address) values(?,?,?,?);";
		i= jdbcTemplate.update(sql,user.getName(),user.getEmail(),user.getPhoneNo(),user.getAddress());
		return i;
	}
	
	public List<User_Bean> getAllUsers() {
		String sql = "select * from user_table";
		return jdbcTemplate.query(sql, new User_Row_Mapper());
	}
	
	

}
 