package com.howmuch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howmuch.domain.BoardLikeVO;
import com.howmuch.mapper.LikeMapper;

import lombok.Setter;

@Service
public class BoardLikeServiceImpl implements BoardLikeService {
	
	@Setter(onMethod_ = @Autowired)
	private LikeMapper mapper;
	
	@Override
	public void firstLike(BoardLikeVO vo) {
		mapper.firstLike(vo);
		
	}

	@Override
	public void firstDislike(BoardLikeVO vo) {
		mapper.firstDislike(vo);
		
	}

	@Override
	public void cancleLike(BoardLikeVO vo) {
		mapper.cancleLike(vo);
		
	}

	@Override
	public void cancleDislike(BoardLikeVO vo) {
		mapper.cancleDislike(vo);
		
	}

	@Override
	public void secondLike(BoardLikeVO vo) {
		mapper.secondLike(vo);
		
	}

	@Override
	public void secondDislike(BoardLikeVO vo) {
		mapper.secondDislike(vo);
		
	}

	@Override
	public BoardLikeVO checkLike(BoardLikeVO vo) {
		
		return mapper.checkLike(vo);
	}

	@Override
	public int likeNumber(BoardLikeVO vo) {
		
		return mapper.likeNumber(vo);
	}

	@Override
	public int dislikeNumber(BoardLikeVO vo) {
		
		return mapper.dislikeNumber(vo);
	}

	@Override
	public void BoardDelete(int bno) {
		mapper.BoardDelete(bno);
		
		
	}

}
