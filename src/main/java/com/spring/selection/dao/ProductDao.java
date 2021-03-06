package com.spring.selection.dao;

import java.util.List;

import com.spring.selection.model.Product;

public interface ProductDao {
	
	/** 상품 목록 */
	public List<Product> productList();
	
	/** 상품 상세 */
	public Product productDetail(int product_no);
}
