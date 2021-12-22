package com.howmuch.mapper;

import com.howmuch.domain.MemberVO;

public interface MemberMapper {
	// 회원가입
	public void signUp1(MemberVO vo);
	public void signUp2(MemberVO vo);
	
	// security에서 username으로 아이디 읽어오기
	public MemberVO read(String email);
	
	
}
