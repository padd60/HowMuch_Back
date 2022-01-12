package com.howmuch.mapper;

import com.howmuch.domain.BoardLikeVO;

public interface LikeMapper {
	
	// 첫 좋아요 눌렀을 때
	public void firstLike(BoardLikeVO vo);
	
	// 첫 싫어요 눌렀을 때
	public void firstDislike(BoardLikeVO vo);
		
	// 좋아요 취소
	public void cancleLike(BoardLikeVO vo);
	
	// 싫어요 취소
	public void cancleDislike(BoardLikeVO vo);
	
	// 좋아요버튼 다시 눌렀을 때
	public void secondLike(BoardLikeVO vo);
	
	// 싫어요버튼 다시 눌렀을 때
	public void secondDislike(BoardLikeVO vo);
	
	// 유저가 좋아요 / 싫어요 눌렀는지 확인하기위한 정보 호출
	public BoardLikeVO checkLike(BoardLikeVO vo);
	
	// 게시물 좋아요 숫자
	public int likeNumber(BoardLikeVO vo);
	
	// 게시물 좋아요 숫자
	public int dislikeNumber(BoardLikeVO vo);
	
	public void BoardDelete(int bno);

}
