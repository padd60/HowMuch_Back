package com.howmuch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howmuch.domain.ReplyLikeVO;
import com.howmuch.mapper.ReplyLikeMapper;

import lombok.Setter;

@Service
public class ReplyLikeServiceImpl implements ReplyLikeService{

	
	@Setter(onMethod_ = @Autowired)
	private ReplyLikeMapper mapper;
	
	
	@Override
	public void firstLike(ReplyLikeVO vo) {
		mapper.firstLike(vo);
	}

	@Override
	public void firstDislike(ReplyLikeVO vo) {
		mapper.firstDislike(vo);
		
	}

	@Override
	public void cancleLike(ReplyLikeVO vo) {
		mapper.cancleLike(vo);
		
	}

	@Override
	public void cancleDislike(ReplyLikeVO vo) {
		mapper.cancleDislike(vo);
		
	}

	@Override
	public void secondLike(ReplyLikeVO vo) {
		mapper.secondLike(vo);
		
	}

	@Override
	public void secondDislike(ReplyLikeVO vo) {
		mapper.secondDislike(vo);
	}

	@Override
	public ReplyLikeVO checkLike(ReplyLikeVO vo) {
		
		return mapper.checkLike(vo);
	}

	@Override
	public int likeNumber(ReplyLikeVO vo) {
		
		return mapper.likeNumber(vo);
	}

	@Override
	public int dislikeNumber(ReplyLikeVO vo) {
	
		return mapper.dislikeNumber(vo);
	}

	@Override
	public void BoardDelete(int bno) {
		
		mapper.BoardDelete(bno);
		
	}

}
