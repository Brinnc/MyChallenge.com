package org.sp.challenges.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.sp.challenges.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisMemberDAO implements MemberDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Member login(Member member) {
		//SqlSession sqlSession=mybatisConfig.getSqlSession();
		Member dto=sqlSessionTemplate.selectOne("Member.login", member);
		
		//mybatisConfig.release(sqlSession);
		
		return dto;
	}
	
	@Override
	public void signup(Member member) {
		int result=sqlSessionTemplate.insert("Member.signup", member);
		
	}
	
	@Override
	public Member findID(Member member) {
		Member dto=sqlSessionTemplate.selectOne("Member.findID", member);
		
		return dto;
	}

}

