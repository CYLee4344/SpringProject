package com.spring.selection.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.selection.dao.ProductDao;
import com.spring.selection.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	SqlSession sqlSession;
	
	/** 惑前 格废 */
	@Override
	public List<Product> productList() {
		return sqlSession.selectList("ProductMapper.productList");
	}
	
	/** 惑前 惑技 */
	@Override
	public Product productDetail(int product_no) {
		return sqlSession.selectOne("ProductMapper.productDetail", product_no);
	}
}
	

