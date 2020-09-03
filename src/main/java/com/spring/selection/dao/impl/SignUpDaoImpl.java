package com.spring.selection.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.selection.dao.SignUpDao;
import com.spring.selection.model.User;

@Repository
public class SignUpDaoImpl implements SignUpDao {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void register(User user) throws Exception {
		sqlSession.insert("UserMapper.register", user);
	}
}
