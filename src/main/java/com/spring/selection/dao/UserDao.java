package com.spring.selection.dao;

import com.spring.selection.model.User;

public interface UserDao {
	
	/** ȸ������ */
	public void register(User user) throws Exception;
	
	/** ���̵� �ߺ� üũ */
	public int idCheck(User user) throws Exception;
	
	/** �α��� */
	public User login(User user) throws Exception;
	
	/** Ż�� */
	public void userDelete(User user) throws Exception;
	
	/** �������� */
	public void userUpdate(User user) throws Exception;

}