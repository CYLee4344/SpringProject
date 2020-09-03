package com.spring.selection.service;

import com.spring.selection.model.User;

public interface UserService {
	public void register(User user) throws Exception;
	
	public User login(User user) throws Exception;
}
