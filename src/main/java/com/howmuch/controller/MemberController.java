package com.howmuch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.howmuch.domain.MemberVO;
import com.howmuch.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/howmuch/*")
@Log4j
@Controller
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
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		if(error != null){
	    	model.addAttribute("error", "로그인 에러: 계정을 확인하십쇼.");
	    }
	    if(logout != null){
	    	model.addAttribute("logout", "로그아웃됨");
	    }
	}
}
