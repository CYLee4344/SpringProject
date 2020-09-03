package com.spring.selection.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.selection.model.User;
import com.spring.selection.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String home() {

		return "index";
	}
	
	@RequestMapping(value = "/login.do")
	public String login() {
		
		return "Login";
	}
	
	@RequestMapping(value = "/signup.do")
	public String signUp() {
		
		return "SignUp";
	}
	
	@RequestMapping(value = "/index.do")
	public String index() {
		
		return "index";
	}
	
}
