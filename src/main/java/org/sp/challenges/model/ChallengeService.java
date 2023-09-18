package org.sp.challenges.model;

import java.util.List;

import org.sp.challenges.domain.Challenge;

public interface ChallengeService {
	public List selectAll();
	public Challenge select(int challenge_idx);
	public void insert(Challenge challenge);
	public void update(Challenge challenge);
	public void delete(int challenge_idx);
	
}
