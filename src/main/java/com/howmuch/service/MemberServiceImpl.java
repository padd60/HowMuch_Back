package com.howmuch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.howmuch.domain.MemberVO;
import com.howmuch.mapper.MemberMapper;

import lombok.Setter;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper member;
	
	@Setter(onMethod_ = @Autowired)
	private PasswordEncoder pwencoder;
	
	// 회원가입
	@Transactional
	public void signUp(MemberVO vo) {
		String after_encoding = pwencoder.encode(vo.getPw());
		vo.setPw(after_encoding);
		member.signUp1(vo);
		member.signUp2(vo);
		
		
	}
	
	// 로그인
	public void logIn(MemberVO vo) {
		
	}

}
