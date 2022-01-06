package com.howmuch.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.howmuch.domain.BoardVO;
import com.howmuch.domain.CalculatorVO;
import com.howmuch.domain.LogVO;
import com.howmuch.domain.MemberVO;
import com.howmuch.domain.ValueVO;
import com.howmuch.service.MemberService;
import com.howmuch.service.ValueService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@CrossOrigin(origins = "*")
@RestController
@Log4j
public class ValueController {
	
		@Setter(onMethod_ = @Autowired)
		private ValueService service;
		
		@Setter(onMethod_ = @Autowired)
		private MemberService mservice;
	
		@GetMapping("/ReadValueList")
		public @ResponseBody List<ValueVO> readList(){
	      return service.getList();
		}

		@PostMapping(value="/RegisterValue")
	 	@PreAuthorize("isAuthenticated()")
	 	public @ResponseBody List<ValueVO> register(@RequestBody ValueVO pri, Principal principal ){
	      
		 	  MemberVO vo = mservice.read(principal.getName());
		 	  
		 	  pri.setMno(vo.getMno());
		 	  pri.setRater(vo.getNick());
		 		
		      log.info(pri.getPrice());
		      log.info(pri.getBno());
		      log.info(pri.getMno());
		      log.info(pri.getRater());
		      
		      List<ValueVO> list = service.getList();
		      
		      for(int i = 0; i < list.size(); i++ ) {
		    	  if(list.get(i).getRater().equals(pri.getRater())) {
		    		  return service.getList();
		    	  }
		      }
		      
		      return service.register(pri);
	   }
		
		@GetMapping(value="/log")
		public @ResponseBody List<LogVO> log(@RequestParam(value="bno") int bno){
				
			log.info("log.............."+bno);
			
			return service.log(bno);
		}
		
		@GetMapping(value="/cal")
		public @ResponseBody CalculatorVO cal(@RequestParam(value="bno") int bno){
			
			CalculatorVO cal = service.cal(bno);
			
			cal.setAvg(Math.round(cal.getAvg()));
			
			return cal;
		}
		
		@PostMapping("/setPoint")
		@PreAuthorize("isAuthenticated()")
		public @ResponseBody CalculatorVO setpoint(BoardVO vo, Principal principal){
			
			CalculatorVO cal = service.cal(vo.getBno());
			
			cal.setAvg(Math.round(cal.getAvg()));
			
			MemberVO user = mservice.read(principal.getName());
			
			if(user.getMno() != vo.getMno()) {
				return null;
			}
			
			double avg = cal.getAvg();
			
			if(avg >= 100000000) {
				user.setPoint(250);
			}
			else if(avg < 100000000) {
				int added = (int)(avg - 1000000)/1000000;
				user.setPoint(100+added);
			}
			else if(avg < 1000000) {
				user.setPoint(70);
			}
			else if(avg < 500000) {
				user.setPoint(50);
			}
			else if(avg < 100000) {
				user.setPoint(30);
			}
			else if(avg < 50000){
				user.setPoint(20);
			}
			else {
				user.setPoint(10);
			}
			
			
			mservice.setPoing(user);
			
			return cal;
			
		}
		
		
		
}
