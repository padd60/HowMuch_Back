package com.howmuch.service;

import com.howmuch.domain.ReplyLikeVO;

public interface ReplyLikeService {
	
	public void firstLike(ReplyLikeVO vo);
	
	// 첫 싫어요 눌렀을 때
	public void firstDislike(ReplyLikeVO vo);
		
	// 좋아요 취소
	public void cancleLike(ReplyLikeVO vo);
	
	// 싫어요 취소
	public void cancleDislike(ReplyLikeVO vo);
	
	// 좋아요버튼 다시 눌렀을 때
	public void secondLike(ReplyLikeVO vo);
	
	// 싫어요버튼 다시 눌렀을 때
	public void secondDislike(ReplyLikeVO vo);
	
	// 유저가 좋아요 / 싫어요 눌렀는지 확인하기위한 정보 호출
	public ReplyLikeVO checkLike(ReplyLikeVO vo);
	
	// 게시물 좋아요 숫자
	public int likeNumber(ReplyLikeVO vo);
	
	// 게시물 좋아요 숫자
	public int dislikeNumber(ReplyLikeVO vo);

}
