package com.howmuch.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class MemberLogController {

	
	// 로그인
		@GetMapping("/customLogin")
		public void loginInput(String error, String logout, Model model) {
			
			log.info("=============================");
			log.info("error : " + error);
			
			log.info("logout : " + logout);
			
			if(error != null){
		    	model.addAttribute("error", "로그인 에러");
		    }
		    if(logout != null){
		    	model.addAttribute("logout", "로그아웃됨");
		    }
		    
		}
		
		// 로그아웃
		@GetMapping("/customLogout")
		@PreAuthorize("isAuthenticated()")
		public void logoutGET() {
			log.info("logout");
		}
		
		
		@GetMapping("/member")
		@PreAuthorize("isAuthenticated()")
		public void member() {
			log.info("success");
		}
}
