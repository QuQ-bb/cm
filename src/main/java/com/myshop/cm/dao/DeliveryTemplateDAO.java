package com.myshop.cm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.cm.model.DeliveryTemplateVO;

@Repository
public class DeliveryTemplateDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 배송템플렛 등록
	@Transactional
	public void insertTemplate(DeliveryTemplateVO deliverytemplate) throws Exception{
		System.out.println("DAO");
		sqlSession.insert("deliveryMapper.insert_template", deliverytemplate);
	}

}
