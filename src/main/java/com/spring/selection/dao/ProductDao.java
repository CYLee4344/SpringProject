package com.spring.selection.dao;

import java.util.List;

import com.spring.selection.model.Product;

public interface ProductDao {
	
	/** ��ǰ ��� */
	public List<Product> productList();
	
	/** ��ǰ �� */
	public Product productDetail(int product_no);
}
