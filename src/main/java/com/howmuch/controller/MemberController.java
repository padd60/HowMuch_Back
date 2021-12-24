package com.howmuch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.howmuch.domain.MemberVO;
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
	
}
