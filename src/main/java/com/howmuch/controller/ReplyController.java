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

import com.howmuch.domain.MemberVO;
import com.howmuch.domain.ReplyVO;
import com.howmuch.service.MemberService;
import com.howmuch.service.ReplyLikeService;
import com.howmuch.service.ReplyService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@CrossOrigin(origins = "*")
@RestController
@Log4j
public class ReplyController {
	
		@Setter(onMethod_ = @Autowired)
		private ReplyService service;
		
		@Setter(onMethod_ = @Autowired)
		private MemberService mservice;
		
		@Setter(onMethod_ = @Autowired)
		private ReplyLikeService rlservice;
	 
		@GetMapping("/ReadReply")
	   public @ResponseBody ReplyVO get(@RequestParam(value="rno") int rno) {
			return service.get(rno);
	   }
	   
	   @GetMapping("/ReadReplyList")
	   public @ResponseBody List<ReplyVO> readList(@RequestParam(value="bno") int bno){
	      return service.getList(bno);
	   }
	  
	   @PostMapping(value="/UpdateReply")
	   public @ResponseBody ReplyVO update(@RequestBody ReplyVO reply) {
	      
	      log.info(reply.getReplyer());
	      log.info(reply.getRcontent());
	      log.info(reply.getRno());
	      
	      return service.update(reply);
	   }
	   
	   @PostMapping(value="/InsertReply")
	   public @ResponseBody List<ReplyVO> insert(@RequestBody ReplyVO reply){
	      
	      log.info(reply.getReplyer());
	 
	      
	      return service.insert(reply);
	   }
	   
	   @DeleteMapping(value="/DeleteReply")
	   @PreAuthorize("isAuthenticated()")
	   public @ResponseBody List<ReplyVO> delete(ReplyVO reply, Principal principal){
		  
	      MemberVO vo = mservice.read(principal.getName());
	      
	      log.info(vo);
	      log.info(reply.getReplyer());
	      log.info(reply.getReplyer().equals(vo.getNick()));
	      log.info(vo.getNick());
	      
	      if(!reply.getReplyer().equals(vo.getNick())) {
	    	  return service.getList(reply.getBno());
	      }
	      
	      rlservice.BoardDelete(reply.getBno());
	      
	      return service.delete(reply);
	   }

}
