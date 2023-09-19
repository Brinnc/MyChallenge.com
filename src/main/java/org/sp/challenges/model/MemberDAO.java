package org.sp.challenges.model;

import org.sp.challenges.domain.Member;

public interface MemberDAO {
	
	public Member login(Member member);
	public void signup(Member member);
	public Member findID(Member member);

}
