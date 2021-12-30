package com.howmuch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.howmuch.domain.MemberVO;
import com.howmuch.domain.Rank2VO;
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
	@GetMapping("/BoardRank")
	public @ResponseBody List<RankVO> rank1() {
		log.info("==========================");
		log.info("My Page");
		
		List<RankVO> rvo = service.getRankByPosting();
		
		return rvo;
		
	}
	
	// 마이페이지
	@GetMapping("/TierRank")
	public @ResponseBody List<Rank2VO> rank2(){
		
		log.info("Rank2");
		List<Rank2VO> rvo = service.getRankByTier();
		
		for(Rank2VO vo : rvo) {
			if(vo.getPoint() < 250) {
				vo.setTier("Bronze");
			}
			else if(vo.getPoint() < 500) {
				vo.setTier("Silver");
			}
			else if(vo.getPoint() < 750) {
				vo.setTier("Gold");
			}
			else if(vo.getPoint() < 1000) {
				vo.setTier("Platinum");
			}
			else {
				vo.setTier("Diamond");
			}
		}
		return rvo;
	}
	
	//이메일 중복찾기
	@GetMapping(value="/findEmail")
	public @ResponseBody MemberVO find(@RequestParam String email) {
		return service.findEmail(email);
	}
	
	//닉네임 중복찾기
	@GetMapping(value="/findNick")
	public @ResponseBody MemberVO findNick(@RequestParam String nick) {
		return service.findNick(nick);
	}
	
}
