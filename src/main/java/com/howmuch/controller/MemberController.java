package com.howmuch.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.howmuch.domain.MemberVO;
import com.howmuch.domain.RankVO;
import com.howmuch.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@CrossOrigin(origins = "*")
@Log4j
@RestController
public class MemberController {
	
	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	// 회원가입
	@PostMapping(value="/signUp")
	public @ResponseBody void signUp(@RequestBody MemberVO vo) {
		log.info("회원가입 정보----");
		log.info("email : " + vo.getEmail());
		log.info("nick : " + vo.getNick());
		service.signUp(vo);
	}
	
	// 마이페이지
//	@GetMapping("/myPage")
//	@PreAuthorize("isAuthenticated()")
//	public @ResponseBody List<RankVO> mypage(String email) {
//		log.info("==========================");
//		log.info("My Page");
//		log.info(principal.getName());
//		
//		MemberVO vo = service.read(email);
//		List<RankVO> rvo = service.getRankByPosting();
//		List<MemberVO> mvo = service.getRankByTier();
//		
//		return rvo;
//		
//	}
	
}
