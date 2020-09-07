package com.spring.selection.dao;

import java.util.List;

import com.spring.selection.model.Product;

public interface ProductDao {
	
	/** 惑前 格废 */
	public List<Product> productList();
	
	/** 惑前 惑技 */
	public Product productDetail(int product_no);
}
