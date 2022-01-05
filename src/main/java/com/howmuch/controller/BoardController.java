package com.howmuch.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.howmuch.domain.BoardVO;
import com.howmuch.domain.MemberVO;
import com.howmuch.service.BoardService;
import com.howmuch.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@CrossOrigin(origins = "*")
@RestController
@Log4j
public class BoardController {
	
		@Setter(onMethod_ = @Autowired)
		private BoardService service;
		
		@Setter(onMethod_ = @Autowired)
		private MemberService mservice;
		
		@GetMapping("/read")
		public @ResponseBody BoardVO read() {
			return service.get();
		}
		
		@GetMapping("/readList")
		public @ResponseBody List<BoardVO> readList(){
			
			
			return service.getList();
		}
		
		@GetMapping("/hotList")
		public @ResponseBody List<BoardVO> hotList(){
			
			return service.hotList();
		}
		
		@PostMapping(value="/update")
		public @ResponseBody List<BoardVO> update(@RequestBody BoardVO vo) {
	
			return service.update(vo);
		}
		
		@PostMapping(value="/register")
		@PreAuthorize("isAuthenticated()")
		public @ResponseBody List<BoardVO> register(@RequestBody BoardVO vo, Principal principal){
			
			MemberVO user = mservice.read(principal.getName());
			
			vo.setWriter(user.getNick());
			vo.setMno(user.getMno());
			
			// 태그설정
			if(vo.getTagList() != null) {
				vo.setTag(String.join(",", vo.getTagList()));
			}
			
			// 이미지 첨부파일 설정
			if(vo.getImageList() != null) {
		        vo.setImage(String.join("_", vo.getImageList()));
		    }
			
			return service.register(vo);
		}
		
		@DeleteMapping(value="/delete")
		public @ResponseBody List<BoardVO> delete(@RequestParam(value="bno") int bno){
			
			return service.delete(bno);
			
		}
		
		@GetMapping("/getSearchList")
		public @ResponseBody List<BoardVO> getSearchList(@RequestParam("type") String type, @RequestParam("keyword") String keyword) {
			BoardVO vo = new BoardVO();
			
			log.info("type : " + type);
			log.info("keyword : " + keyword);
			
			vo.setType(type);
			vo.setKeyword(keyword);
			return service.getSearchList(type, keyword);
		}
		
		@GetMapping(value="/rcount")
	    public void rcount(@RequestParam(value="bno") int bno){
		      
			service.rcount(bno);
			
	   }
		@PostMapping(value="/blike")
	    public void blike(@RequestParam(value="bno") int bno){
		      
		      service.blike(bno);
		      
	   }
		   
	   @PostMapping(value="/bdislike")
	   public void bdislike(@RequestParam(value="bno") int bno){
	      
		      service.bdislike(bno);
		      
	   }
	
}
