package com.myshop.cm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	public Object getmemberInfo(int mem_num) {
		return sqlSession.selectOne("memberMapper.select_member",mem_num);
	}
}
