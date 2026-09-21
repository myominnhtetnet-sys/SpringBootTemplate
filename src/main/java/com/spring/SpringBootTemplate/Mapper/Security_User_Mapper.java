package com.spring.SpringBootTemplate.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.spring.SpringBootTemplate.Model.Security_User;

public class Security_User_Mapper implements RowMapper<Security_User> {

	@Override
	public Security_User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Security_User user = new Security_User();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setEnabled(rs.getBoolean("enabled"));
		user.setRolerName(rs.getString("role_name"));
		return user;
	}

}
