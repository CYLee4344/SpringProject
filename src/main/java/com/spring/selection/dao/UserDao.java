package com.spring.selection.dao;

import com.spring.selection.model.User;

public interface UserDao {
	
	/** 회원가입 */
	public void register(User user) throws Exception;
	
	/** 아이디 중복 체크 */
	public int idCheck(User user) throws Exception;
	
	/** 로그인 */
	public User login(User user) throws Exception;
	
	/** 탈퇴 */
	public void userDelete(User user) throws Exception;
	
	/** 정보수정 */
	public void userUpdate(User user) throws Exception;
	
	/** 아이디 찾기 */
	public User findID(User user) throws Exception;
	
	/** 이메일 유무체크 */
	public int emailCheck(User user) throws Exception;

}