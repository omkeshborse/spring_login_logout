package com.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.model.userModel;

public class userDao {
	@Autowired
	JdbcTemplate t1;
	 
	public void setT1(JdbcTemplate t1) {
		this.t1 = t1;
	}
	
	
	public int saveInfo(userModel u1) {
		String insertQuery = "INSERT INTO users (first_name , last_name ,password , gender , email , phone_number ,postal_code ) VALUES ( '"+u1.getFirst_name()+"' ,'"+u1.getLast_name()+"' , '"+u1.getPassword()+"' , '"+u1.getGender()+"' , '"+u1.getEmail()+"' , '"+u1.getPhone_number()+"' , '"+u1.getPostal_code()+"' )" ;
		
		
		return t1.update(insertQuery) ;
	}


	public List<userModel> checkUserExists(userModel u1) {
		
		String selectQueryByEmail = " SELECT * FROM users WHERE email = '"+u1.getEmail()+"' " ;
		return t1.query(selectQueryByEmail, new RowMapper<userModel>() {

			@Override
			public userModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				userModel ur = new userModel() ;
				ur.setId(rs.getInt(1));
				ur.setFirst_name(rs.getString(2));
				ur.setLast_name(rs.getString(3));
				ur.setPassword(rs.getString(4));
				ur.setGender(rs.getString(5));
				ur.setEmail(rs.getString(6));
				ur.setPhone_number(rs.getString(7));
				ur.setPostal_code(rs.getString(8));
				return ur;
			}}) ;
	}


	public List<userModel> checkCheredentials(userModel u1) {
		// TODO Auto-generated method stub

		String selectQueryByEmailPassword = " SELECT * FROM users WHERE email = '"+u1.getEmail()+"' and password = '"+u1.getPassword()+"' " ;
		return t1.query(selectQueryByEmailPassword, new RowMapper<userModel>() {

			@Override
			public userModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				userModel ur = new userModel() ;
				ur.setId(rs.getInt(1));
				ur.setFirst_name(rs.getString(2));
				ur.setLast_name(rs.getString(3));
				ur.setPassword(rs.getString(4));
				ur.setGender(rs.getString(5));
				ur.setEmail(rs.getString(6));
				ur.setPhone_number(rs.getString(7));
				ur.setPostal_code(rs.getString(8));
				return ur;
			}}) ;
	}
	
	

	

}
