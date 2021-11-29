package com.myshop.cm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myshop.cm.model.DeliveryTemplateVO;

@Repository
public class DeliveryTemplateDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 배송템플렛 등록
	public void insertTemplate(DeliveryTemplateVO deliverytemplate) throws Exception{
		System.out.println("DAO");
		sqlSession.insert("deliveryMapper.insert_template", deliverytemplate);
	}
	
	// 배송템플릿 리스트 구해오기
	public List<DeliveryTemplateVO> getTemplateList() throws Exception{
		List<DeliveryTemplateVO> list = sqlSession.selectList("deliveryMapper.select_template_list");
		
		return list;
	}

	// 배송템플릿 상세정보 구해오기
	public DeliveryTemplateVO getTemplate(int deltem_num) throws Exception{
		return (DeliveryTemplateVO) sqlSession.selectOne("deliveryMapper.select_template", deltem_num);
	}

	// 배송템플릿 개수 구해오기
	public int getTemplateCount() throws Exception{
		return sqlSession.selectOne("deliveryMapper.select_template_count");
	}

	// 배송템플릿 수정하기
	public void editdeltem(DeliveryTemplateVO deliverytemplate) throws Exception{
		sqlSession.update("deliveryMapper.update_template", deliverytemplate);
		
	}
	// 배송템플릿 삭제하기
	public void deletedelitem(int deltem_num) {
		sqlSession.delete("deliveryMapper.delete_template", deltem_num);
		
	}

}
