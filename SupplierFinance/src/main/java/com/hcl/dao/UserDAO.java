package com.hcl.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hcl.model.User;

public class UserDAO {
	JdbcTemplate jdbcTemplate;

	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public int saveClient(User user) {
		String sql = "INSERT INTO user_client (Userid, Password, FName, LName, Address, City, Province, Country, Email, Mobile, Loan_no, Loan_info) VALUES ('"
				+ user.getUsername()
				+ "', '"
				+ user.getPassword()
				+ "', '"
				+ user.getName()
				+ "', '"
				+ ""
				+ "', '"
				+ user.getAddress()
				+ "', '"
				+ user.getCity()
				+ "', '"
				//+ user.getState()
				//+ "', '"
				+ user.getProvince()
				+ "', '"
				+ user.getCountry()
				+ "', '"
				+ user.getEmail()
				+ "', '"
				+ user.getMobile()
				+ "', '"
				+ user.getLoanNo() + "', '" + user.getLoanInfo() + "')";
		return jdbcTemplate.update(sql);
	}

	public int saveSupplier(User user) {
		String sql = "INSERT INTO user_supplier (Username, Password, FName, Address, City, State, Province, Country, Email, Mobile, Credit_no, Credit_info) VALUES ('"
				+ user.getUsername()
				+ "', '"
				+ user.getPassword()
				+ "', '"
				+ user.getName()
				+ "', '"
				+ user.getAddress()
				+ "', '"
				+ user.getCity()
				+ "', '"
				+ user.getState()
				+ "', '"
				+ user.getProvince()
				+ "', '"
				+ user.getCountry()
				+ "', '"
				+ user.getEmail()
				+ "', '"
				+ user.getMobile()
				+ "', '"
				+ user.getCreditNo() + "', '" + user.getCreditInfo() + "')";
		return jdbcTemplate.update(sql);
	}

	public boolean getUserClient(String username, String password) {
		String sql = "SELECT userid, password FROM user_client WHERE userid = ? AND password = ?";
		boolean user;
		try {
			jdbcTemplate.queryForObject(sql,
					new Object[] { username, password },
					new BeanPropertyRowMapper<User>(User.class));
			user = true;
		} catch (EmptyResultDataAccessException e) {
			user = false;
		}

		return user;
	}

	public boolean getUserSupplier(String username, String password) {
		String sql = "SELECT userid, password FROM user_supplier WHERE userid = ? AND password = ?";
		boolean user;
		try {
			jdbcTemplate.queryForObject(sql,
					new Object[] { username, password },
					new BeanPropertyRowMapper<User>(User.class));
			user = true;
		} catch (EmptyResultDataAccessException e) {
			user = false;
		}

		return user;
	}

	public boolean getAdmin(String username, String password) {
		String sql = "SELECT userid, password FROM user_admin WHERE userid = ? AND password = ?";
		boolean user;
		try {
			jdbcTemplate.queryForObject(sql,
					new Object[] { username, password },
					new BeanPropertyRowMapper<User>(User.class));
			user = true;
		} catch (EmptyResultDataAccessException e) {
			user = false;
		}

		return user;
	}
}
