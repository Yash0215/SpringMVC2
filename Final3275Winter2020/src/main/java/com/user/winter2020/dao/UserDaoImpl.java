package com.user.winter2020.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.user.winter2020.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private static final class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setEmail(rs.getString("email"));
			user.setUserName(rs.getString("name"));
			user.setGender(rs.getString("gender"));
			return user;
		}
	}
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	@Override
	public List<User> findByGender(String gender) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("gender", gender);
		String sql = "SELECT * FROM users WHERE gender=:gender";
		List<User> users = null;
		try {
			users = namedParameterJdbcTemplate.query(sql, params, new UserMapper());
			System.out.println("Getting Total users: " + users.size());
			return users;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

}
