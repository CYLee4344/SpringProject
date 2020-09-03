package com.spring.selection.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.selection.model.User;
import com.spring.selection.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	/** 회원가입 */
	@RequestMapping(value = "/UserRegister.do", method = RequestMethod.POST)
	public String register(User user) throws Exception {
		service.register(user);
		return "index";
	}
	
	/** 로그인 */
	@RequestMapping(value = "/UserLogin.do", method = RequestMethod.POST)
	public String login(User user, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		
		HttpSession session = req.getSession();
		// 세션 유지 시간 session.setMaxInactiveInterval();
		User login = service.login(user);
		
		if(login == null) {
			session.setAttribute("user", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			session.setAttribute("user", login);
		}

		return "redirect:/";
	}
	
	/** 로그아웃 */
	@RequestMapping(value = "/UserLogout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	/** 회원탈퇴 */
	@RequestMapping(value = "/UserDelete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String userDelete(User user, HttpSession session) throws Exception {
		
		User user1 = (User) session.getAttribute("user");
		
		service.userDelete(user1);
		session.invalidate();
		
		return "redirect:/";
	}

}
