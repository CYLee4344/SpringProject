package com.spring.selection.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public void login(User user, HttpServletRequest req, RedirectAttributes rttr, HttpServletResponse response) throws Exception {
		
		HttpSession session = req.getSession();
		// 세션 유지 시간 session.setMaxInactiveInterval();
		User login = service.login(user);
		
		if(login == null) {
			session.setAttribute("user", null);
			response.getWriter().print(false);
//			rttr.addFlashAttribute("msg", false);
		} else {
			session.setAttribute("user", login);
			response.getWriter().print(true);
		}
	}
	
//	@RequestMapping(value = "/login.do", method = {RequestMethod.GET, RequestMethod.POST})
//	public ModelAndView login(@ModelAttribute User user, HttpServletResponse response, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
//		ModelAndView mav = new ModelAndView();
//		HttpSession session = req.getSession();
//		PrintWriter out= response.getWriter();
//		// 세션 유지 시간 session.setMaxInactiveInterval();
//		User login = service.login(user);
//		
//		if(login == null) {
//			session.setAttribute("user", null);
//			mav.setViewName("Login");
//			mav.addObject("msg", false);
//		} else {
//			session.setAttribute("user", login);
//			mav.setViewName("index");
//		}
//		return mav;
//	}

//	@RequestMapping(value = "/bottomLogin.do")
//	public String bottomLogin(HttpServletRequest req) {
//		HttpSession session = req.getSession();
//		if(session.getAttribute("user") == null) {
//			return "Login";
//		} else {
//			ale
//			return "index";
//		}
//	}
	
	/** 아이디 중복체크 */
	@ResponseBody
	@RequestMapping(value = "/IdCheck.do", method = RequestMethod.POST)
	public int idCheck(User user) throws Exception {
		int result = service.idCheck(user);
		return result;
	}
	
	/** 로그아웃 */
	@RequestMapping(value = "/UserLogout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	/** 회원정보수정 */
	@RequestMapping(value = "/UserUpdate.do", method = RequestMethod.POST)
	public String userUpdate(User user, HttpSession session) throws Exception {
		
		service.userUpdate(user);
		session.invalidate();
		return "Login";
	}
	
	/** 회원탈퇴 */
	@RequestMapping(value = "/UserDelete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String userDelete(User user, HttpSession session) throws Exception {

		User user1 = (User) session.getAttribute("user");
		
		service.userDelete(user1);
		session.invalidate();
		
		return "redirect:/";
	}
	
	/** 아이디 찾기 
	 * @return */
	@RequestMapping(value = "/FindID.do", method = RequestMethod.POST) 
	public String findID(Model model, HttpServletResponse response,
	  @RequestParam(value="user_email", required=true) String user_email) {
	  
	  // 데이터 조회에 필요한 조건값을 Beans에 저장하기 
	  User user1 = new User();
	  user1.setUser_email(user_email);
	  
	  // 조회결과를 저장할 객체 선언 
	  User output = null;
	  
	  try { 
		  // 데이터 조회 
		  output = service.findID(user1); 
	  } catch (Exception e) {
		  e.printStackTrace(); 
	  }
	  
	  // View 처리 
	  model.addAttribute("output",output); 
	  return "Search_ID"; 
	}
	
	/** 이메일 유무체크 */
	@ResponseBody
	@RequestMapping(value = "/EmailCheck.do", method = RequestMethod.POST)
	public int emailCheck(User user) throws Exception {
		int result = service.emailCheck(user);
		return result;
	}
	
}
