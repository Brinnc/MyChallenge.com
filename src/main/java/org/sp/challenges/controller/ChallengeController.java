package org.sp.challenges.controller;

import javax.servlet.http.HttpSession;

import org.sp.challenges.domain.Challenge;
import org.sp.challenges.domain.Member;
import org.sp.challenges.model.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChallengeController {
	
	@Autowired
	private ChallengeService challengeService;

	//메인 페이지 요청
	@GetMapping("/challenges/main")
	public ModelAndView getMain() {
		
		ModelAndView mav=new ModelAndView("challenges/main");
		
		return mav;
	}
	
	//챌린지 등록폼 요청
	@GetMapping("/challenges/challengeform")
	public ModelAndView getChallengeForm() {
		ModelAndView mav=new ModelAndView("challenges/challengeform");
		
		return mav;
	}
	
	//챌린지 등록
	@PostMapping("/challenges/regist")
	public ModelAndView regist(Challenge challenge, HttpSession session) {
		//3단계) DB에 넣기(오라클)
		Member member=(Member)session.getAttribute("member");
		System.out.println("해당 글에서의 member_idx는 "+member.getMember_idx());
		challenge.setMember(member); //★★★★★
		
		challengeService.insert(challenge, member);
		//request.getAttribute("member", member.getMember_idx());
		
		//4단계) 저장X, redirect
		ModelAndView mav=new ModelAndView("redirect:/challenges/main");
		
		return mav;
	}
	
	//@ExceptionHandler(ChallengeException.class)
	//public ModelAndView handle(ChallengeException e) {
		//발생한 예외객체를 jsp에서 볼 수 있도록 결과 저장
		//ModelAndView mav=new ModelAndView("error/result"); 
		//mav.addObject("e", e);
		
		//return mav;
	//}
	
}
