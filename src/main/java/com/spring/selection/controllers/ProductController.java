package com.spring.selection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.selection.model.Product;
import com.spring.selection.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService service;
	
	/** 惑前 格废 */
	@RequestMapping(value = "/ProductList.do", method = RequestMethod.GET)
	public ModelAndView productList(ModelAndView mav) {
		mav.setViewName("ProductList");
		mav.addObject("list", service.productList());
		return mav;
	}
	
	/** 惑前 惑技 */
	@RequestMapping(value = "/ProductDetail.do/{product_no}", method = RequestMethod.GET)
	public ModelAndView productDetail(@PathVariable("product_no") int product_no, ModelAndView mav) {
		mav.setViewName("ProductDetail");
		mav.addObject("product", service.productDetail(product_no));
		return mav;
	}
}
