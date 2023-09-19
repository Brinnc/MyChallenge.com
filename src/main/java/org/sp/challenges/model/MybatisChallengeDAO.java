package org.sp.challenges.model;

import java.util.List;

import org.apache.ibatis.cache.CacheException;
import org.mybatis.spring.SqlSessionTemplate;
import org.sp.challenges.domain.Challenge;
import org.sp.challenges.domain.Member;
import org.sp.challenges.exception.ChallengeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisChallengeDAO implements ChallengeDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Challenge select(int challenge_idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Challenge challenge, Member member) throws ChallengeException{
		int result=sqlSessionTemplate.insert("Challenge.insert", challenge);
		
		if(result<1) {
			throw new CacheException("챌린지 등록 실패");
		}
		
	}

	@Override
	public void update(Challenge challenge) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int challenge_idx) {
		// TODO Auto-generated method stub
		
	}

}
