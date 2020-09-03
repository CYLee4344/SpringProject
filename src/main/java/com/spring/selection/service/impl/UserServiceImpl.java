package com.spring.selection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.selection.dao.UserDao;
import com.spring.selection.model.User;
import com.spring.selection.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao dao;
	
	@Override
	public void register(User user) throws Exception {
		dao.register(user);
	}

	@Override
	public User login(User user) throws Exception {
		
		return dao.login(user);
	}

	@Override
	public void userDelete(User user) throws Exception {
		dao.userDelete(user);
		
	}

}
