package com.myshop.cm.dao;

import java.util.List;

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

	public List<DeliveryTemplateVO> getTemplateList() {
		List<DeliveryTemplateVO> list = sqlSession.selectList("deliveryMapper.select_template_list");
		
		return list;
	}

	public DeliveryTemplateVO getTemplate(int deltem_num) {
		return (DeliveryTemplateVO) sqlSession.selectOne("deliveryMapper.select_template", deltem_num);
	}

}
