package org.sp.challenges.model;

import java.util.List;

import org.sp.challenges.domain.Challenge;
import org.sp.challenges.domain.Member;
import org.sp.challenges.exception.ChallengeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeServiceImpl implements ChallengeService{

	@Autowired
	private ChallengeDAO challengeDAO;
	
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
		challengeDAO.insert(challenge, member);
		
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
