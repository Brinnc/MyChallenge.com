package org.sp.challenges.model;

import java.util.List;

import org.sp.challenges.domain.Challenge;
import org.sp.challenges.domain.Member;

public interface ChallengeDAO {
	public List selectAll();
	public Challenge select(int challenge_idx);
	public void insert(Challenge challenge, Member member);
	public void update(Challenge challenge);
	public void delete(int challenge_idx);
	
}
