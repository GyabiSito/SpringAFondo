package com.gyabisito.user.services;

import java.util.List;

import com.gyabisito.user.entity.User;

public interface UserService {
	
	int save(com.gyabisito.user.entity.User user);

	List<User> getUsers();
	
	User getUser(Integer id);
}
