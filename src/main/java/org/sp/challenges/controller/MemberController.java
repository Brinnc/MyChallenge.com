package org.sp.challenges.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sp.challenges.domain.Member;
import org.sp.challenges.exception.MemberException;
import org.sp.challenges.model.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	// 로그인 폼 요청
	@GetMapping("/member/loginform")
	public ModelAndView loginform() {
		ModelAndView mav = new ModelAndView("member/loginform");

		return mav;
	}
	
	// ID찾기 폼 요청
	@GetMapping("/member/forgetform")
	public ModelAndView forgetform() {
		ModelAndView mav=new ModelAndView("member/forgetform");
		
		return mav;
	}
	
	
	// ID 확인 페이지 요청
	@PostMapping("/member/findID")
	public ModelAndView Find(Member member, HttpServletRequest request) {
		
		// 3단계) 일치하는 계정 정보가 있는지 조회
		Member dto = memberService.findID(member);

		// 4단계) 일치하는 정보가 있다면, 세션에 DTO를 담아 서비스
		HttpSession session = request.getSession();
		session.setAttribute("member", dto);

		ModelAndView mav=new ModelAndView("member/findID"); // redirect 시
		
		return mav;
	}
	
	
	// 회원 가입 폼 요청
	@GetMapping("/member/signupform")
	public ModelAndView signupform() {
		ModelAndView mav=new ModelAndView("member/signupform");
		
		return mav;
	}
	
	// 회원 가입 약관 페이지 요청
	@GetMapping("/member/agree")
	public ModelAndView getAgree() {
		ModelAndView mav=new ModelAndView("member/agree");
		
		return mav;
	}
	
	// 회원 가입 요청 처리
	@PostMapping("/member/signup")
	public String signUp(Member member, HttpServletRequest request) {
		
		memberService.signup(member);
		
		return "redirect:/member/loginform";
	}

	/*
	// 관리자 메인 요청 처리
	@GetMapping("/main")
	public ModelAndView getMain() {
		ModelAndView mav = new ModelAndView("admin/main");

		return mav;
	}
	*/

	// 로그인 요청 처리
	@PostMapping("/member/login")
	public ModelAndView login(Member member, HttpServletRequest request) {
		// 3단계) 일치하는 계정 정보가 있는지 조회
		Member dto = memberService.login(member);

		// 4단계) 일치하는 정보가 있다면, 세션에 DTO를 담아 서비스
		HttpSession session = request.getSession();
		session.setAttribute("member", dto);

		ModelAndView mav = new ModelAndView("redirect:/challenges/main"); // redirect 시

		return mav;
	}

	/*
	// 카카오 로그인 요청 처리
	// 1) 카카오톡에 사용자 코드 받기 (jsp의 a태그 href에 경로 있음)
	@RequestMapping(value = "/kakaoLogin", method = RequestMethod.GET)
	public ModelAndView kakaoLogin(@RequestParam(value = "code", required = false) String code) throws Throwable {

		// 1번
		System.out.println("code:" + code);
		return null;
		// return에 페이지를 해도 되고, 여기서는 코드가 넘어오는지만 확인할거기 때문에 따로 return 값을 두지는 않았음

	}
	*/

	@ExceptionHandler(MemberException.class)
	public ModelAndView handle(MemberException e) {
		ModelAndView mav = new ModelAndView("error/result");
		mav.addObject("e", e);

		return mav;
	}
}
