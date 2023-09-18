package org.sp.challenges.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChallengeController {

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
	public ModelAndView regist() {
		//3단계)
		
		//4단계) 저장X, redirect
		ModelAndView mav=new ModelAndView("redirect:/challenges/main");
		
		return mav;
	}
	
}
