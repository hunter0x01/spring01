package com.emobox.spring01.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.emobox.spring01.model.dto.MemberDTO;

@Repository // Spring 관리 
public class MemberDAOImpl implements MemberDAO {

	@Inject // 추가
	SqlSession sqlSession; // 추가 MyBatis 개체관리 Spring이 할수 있도록 
	
	@Override
	public List<MemberDTO> list() {
		// TODO Auto-generated method stub
		//return null;
		return sqlSession.selectList("member.list"); // mybatis member.list 선택 
	}

	@Override
	public void insert(MemberDTO tdo) {
		// TODO Auto-generated method stub
		sqlSession.insert("member.insert", tdo);
		
	}

}
