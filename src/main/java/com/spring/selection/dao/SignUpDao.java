package com.spring.selection.dao;

import com.spring.selection.model.User;

public interface SignUpDao {
	public void register(User user) throws Exception;
	
	public User login(User user) throws Exception;

}
