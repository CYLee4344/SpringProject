package com.spring.selection.service;

import java.util.List;

import com.spring.selection.model.Product;

public interface ProductService {
	
	/** 惑前 格废 */
	public List<Product> productList();
	
	/** 惑前 惑技 */
	public Product productDetail(int product_no);

}
