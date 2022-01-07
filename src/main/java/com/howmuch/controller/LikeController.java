package com.howmuch.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.howmuch.domain.BoardLikeVO;
import com.howmuch.domain.BoardVO;
import com.howmuch.domain.MemberVO;
import com.howmuch.service.BoardLikeService;
import com.howmuch.service.BoardService;
import com.howmuch.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@CrossOrigin(origins = "*")
@RestController
@Log4j
public class LikeController {
	
	@Setter(onMethod_ = @Autowired)
	private BoardLikeService service;
	
	@Setter(onMethod_ = @Autowired)
	private MemberService mservice;
	
	@Setter(onMethod_ = @Autowired)
	private BoardService bservice;
	
	@GetMapping("/like")
	@PreAuthorize("isAuthenticated()")
	public @ResponseBody BoardLikeVO like(BoardLikeVO vo, Principal principal){
		
		MemberVO user = mservice.read(principal.getName());
		
		BoardLikeVO check = service.checkLike(vo);
		
		BoardVO board = bservice.get(vo.getBno());
		
		if(check == null) {
			service.firstLike(vo);
		}
		else {
			service.secondLike(vo);
			service.cancleDislike(vo);
		}
		
		check = service.checkLike(vo);
		
		int likeNum = service.likeNumber(vo);
		int dislikeNum = service.dislikeNumber(vo);
		
		board.setBlike(likeNum);
		board.setBdislike(dislikeNum);
		
		bservice.likedislike(board);
		
		return check;
	}
	
	@GetMapping("/dislike")
	@PreAuthorize("isAuthenticated()")
	public @ResponseBody BoardLikeVO dislike(BoardLikeVO vo, Principal principal){

		MemberVO user = mservice.read(principal.getName());
		
		BoardLikeVO check = service.checkLike(vo);
		
		BoardVO board = bservice.get(vo.getBno());
		
		if(check == null) {
			service.firstDislike(vo);
		}
		else {
			service.secondDislike(vo);
			service.cancleLike(vo);
		}
		
		check = service.checkLike(vo);
		
		int likeNum = service.likeNumber(vo);
		int dislikeNum = service.dislikeNumber(vo);
		
		board.setBlike(likeNum);
		board.setBdislike(dislikeNum);
		
		bservice.likedislike(board);
		
		return check;
	}

}



