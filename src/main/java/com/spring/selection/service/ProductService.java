package com.spring.selection.service;

import java.util.List;

import com.spring.selection.model.Product;

public interface ProductService {
	
	/** ��ǰ ��� */
	public List<Product> productList();
	
	/** ��ǰ �� */
	public Product productDetail(int product_no);

}
