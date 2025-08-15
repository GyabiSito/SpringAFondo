package com.gyabisito.user.dao;

import java.util.List;

import com.gyabisito.user.entity.User;

public interface UserDao {

	int create(com.gyabisito.user.entity.User user);
	
	List<User> findUsers();
	
	User findUser(Integer id);
}
