package com.spring.selection.service;

import com.spring.selection.model.User;

public interface UserService {
	public void register(User user) throws Exception;
	
	public User login(User user) throws Exception;
	
	public void userDelete(User user) throws Exception;
	
	public void userUpdate(User user) throws Exception;
	
	public int idCheck(User user) throws Exception;
	
	public User findID(User user) throws Exception;
	
	public int emailCheck(User user) throws Exception;
}
