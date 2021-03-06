package com.howmuch.service;

import java.util.List;

import com.howmuch.domain.MemberVO;
import com.howmuch.domain.Rank2VO;
import com.howmuch.domain.RankVO;

public interface MemberService {
	// 회원가입
	public void signUp(MemberVO vo);
	
	// MyPage
	public List<RankVO> getRankByPosting();
	public List<Rank2VO> getRankByTier();
	
	// email로 정보가져오기
	public MemberVO read(String email);
	
	// search email same
	public MemberVO findEmail(String email);
	
	// search nick same
	public MemberVO findNick(String nick);
	
	// 포인트 책정
	public void setPoint(MemberVO vo);
}
