package com.spring.SpringBootTemplate.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.spring.SpringBootTemplate.Model.User_Bean;

public class User_Row_Mapper implements RowMapper<User_Bean> {

	@Override
	public User_Bean mapRow(ResultSet rs, int rowNum) throws SQLException {
		User_Bean user = new User_Bean();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPhoneNo(rs.getString("ph_NO"));
		user.setAddress(rs.getString("address"));
		return user;
	}

}
