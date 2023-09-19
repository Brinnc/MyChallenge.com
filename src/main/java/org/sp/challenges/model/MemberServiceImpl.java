package org.sp.challenges.model;


import org.sp.challenges.domain.Member;
import org.sp.challenges.exception.MemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public Member login(Member member) throws MemberException{
		
		Member dto=memberDAO.login(member);
		
		//로그인 실패 시 예외처리
		if(dto==null) {
			throw new MemberException("⚠️ Login Failed ! ⚠️");
		}
		
		return dto;
	}
	
	@Override
	public void signup(Member member) {
		memberDAO.signup(member);
		
	}
	
	@Override
	public Member findID(Member member) throws MemberException{
		Member dto=memberDAO.findID(member);
		
		//아이디찾기 실패 시 예외처리
		if(dto==null) {
			throw new MemberException("⚠️ 회원 정보를 다시 확인해주세요 ! ⚠️");
		}
		
		return dto;
	}
	
}
