package com.spring.selection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.selection.dao.SignUpDao;
import com.spring.selection.model.User;
import com.spring.selection.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	SignUpDao dao;
	
	@Override
	public void register(User user) throws Exception {
		dao.register(user);
	}

}
