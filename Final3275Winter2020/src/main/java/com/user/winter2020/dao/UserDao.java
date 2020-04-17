package com.user.winter2020.dao;

import java.util.List;

import com.user.winter2020.model.User;
 
public interface UserDao {

	List<User> findByGender(String gender);
	 
}
