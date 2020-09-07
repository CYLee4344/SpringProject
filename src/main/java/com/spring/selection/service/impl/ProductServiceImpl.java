package com.spring.selection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.selection.dao.ProductDao;
import com.spring.selection.model.Product;
import com.spring.selection.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired 
	ProductDao dao;
	
	/** ��ǰ ��� */
	@Override
	public List<Product> productList() {
		return dao.productList();
	}
	
	/** ��ǰ �� */
	@Override
	public Product productDetail(int product_no) {
		return dao.productDetail(product_no);
	}


}
