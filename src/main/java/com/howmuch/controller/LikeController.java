package com.howmuch.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.howmuch.domain.BoardLikeVO;
import com.howmuch.domain.BoardVO;
import com.howmuch.domain.MemberVO;
import com.howmuch.domain.ReplyLikeVO;
import com.howmuch.domain.ReplyVO;
import com.howmuch.service.BoardLikeService;
import com.howmuch.service.BoardService;
import com.howmuch.service.MemberService;
import com.howmuch.service.ReplyLikeService;
import com.howmuch.service.ReplyService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@CrossOrigin(origins = "*")
@RestController
@Log4j
public class LikeController {
	
	@Setter(onMethod_ = @Autowired)
	private BoardLikeService service;
	
	@Setter(onMethod_ = @Autowired)
	private ReplyLikeService rlservice;
	
	@Setter(onMethod_ = @Autowired)
	private MemberService mservice;
	
	@Setter(onMethod_ = @Autowired)
	private BoardService bservice;
	
	@Setter(onMethod_ = @Autowired)
	private ReplyService rservice;
	
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
			if(check.getChecklike() == 1) {
				service.cancleLike(vo);
			}
			else {
				service.secondLike(vo);
			}
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
			if(check.getCheckdislike() == 1) {
				service.cancleDislike(vo);
			}
			else {
				service.secondDislike(vo);
			}
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
	
	@GetMapping("/Rlike")
	@PreAuthorize("isAuthenticated()")
	public @ResponseBody ReplyLikeVO Rlike(ReplyLikeVO vo, Principal principal){
		
		MemberVO user = mservice.read(principal.getName());
		
		ReplyLikeVO check = rlservice.checkLike(vo);
		
		log.info(check);
		
		ReplyVO reply = rservice.get(vo.getRno());
		
		if(check == null) {
			rlservice.firstLike(vo);
		}
		else {
			if(check.getRchecklike() == 1) {
				rlservice.cancleLike(vo);
			}
			else {
				rlservice.secondLike(vo);
			}
			rlservice.cancleDislike(vo);
		}
		
		check = rlservice.checkLike(vo);
		
		int likeNum = rlservice.likeNumber(vo);
		int dislikeNum = rlservice.dislikeNumber(vo);
		
		reply.setRelike(likeNum);
		reply.setRedislike(dislikeNum);
		
		rservice.likedislike(reply);
		
		return check;
	}

	@GetMapping("/Rdislike")
	@PreAuthorize("isAuthenticated()")
	public @ResponseBody ReplyLikeVO Rdislike(ReplyLikeVO vo, Principal principal){

		MemberVO user = mservice.read(principal.getName());
		
		log.info(user);
		
		ReplyLikeVO check = rlservice.checkLike(vo);
		
		log.info(check);
		
		ReplyVO reply = rservice.get(vo.getRno());
		
		if(check == null) {
			rlservice.firstDislike(vo);
		}
		else {
			if(check.getRcheckdislike() == 1) {
				rlservice.cancleDislike(vo);
			}
			else {
				rlservice.secondDislike(vo);
			}
			rlservice.cancleLike(vo);
		}
		
		check = rlservice.checkLike(vo);
		
		int likeNum = rlservice.likeNumber(vo);
		int dislikeNum = rlservice.dislikeNumber(vo);
		
		reply.setRelike(likeNum);
		reply.setRedislike(dislikeNum);
		
		rservice.likedislike(reply);
		
		return check;
	}
	
	@GetMapping("/replyreaded")
	@PreAuthorize("isAuthenticated()")
	public @ResponseBody ReplyLikeVO rreaded(int bno, Principal principal) {
		
		MemberVO user = mservice.read(principal.getName());
		
		ReplyLikeVO vo = new ReplyLikeVO();
		vo.setBno(bno);
		vo.setMno(user.getMno());
		
		
		return rlservice.checkLike(vo);
		
		
	}
	
	@GetMapping("/readed")
	@PreAuthorize("isAuthenticated()")
	public @ResponseBody BoardLikeVO readed(int bno, Principal principal) {
		
		MemberVO user = mservice.read(principal.getName());
		
		BoardLikeVO vo = new BoardLikeVO();
		vo.setBno(bno);
		vo.setMno(user.getMno());
		
		
		return service.checkLike(vo);
		
		
	}

}



