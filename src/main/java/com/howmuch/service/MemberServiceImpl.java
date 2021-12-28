package com.howmuch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.howmuch.domain.MemberVO;
import com.howmuch.domain.RankVO;
import com.howmuch.mapper.MemberMapper;

import lombok.Setter;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper member;
	
	@Setter(onMethod_ = @Autowired)
	private BCryptPasswordEncoder pwencoder;
	
	// 회원가입
	@Transactional
	public void signUp(MemberVO vo) {
		String after_encoding = pwencoder.encode(vo.getPw());
		vo.setPw(after_encoding);
		member.signUp1(vo);
		member.signUp2(vo);
		
		
	}

	@Override
	public List<RankVO> getRankByPosting() {
		return member.getRankByPosting();
	}

	@Override
	public MemberVO read(String email) {

		return member.read(email);
	}

	@Override
	public List<MemberVO> getRankByTier() {
		
		return member.getRankByTier();
	}

}