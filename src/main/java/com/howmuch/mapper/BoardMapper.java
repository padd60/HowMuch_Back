package com.howmuch.mapper;

import java.util.List;

import com.howmuch.domain.BoardVO;

public interface BoardMapper {
	
	public BoardVO getData(int bno);
	
	public List<BoardVO> getList();
	
	public List<BoardVO> hotList();
	
	public int updateData(BoardVO vo);
	
	public void register(BoardVO vo);
	
	public void delete(BoardVO board);
	
	public void rcount(int bno);

	public List<BoardVO> selectSearchList(String type, String keyword);
	
	public void checkEnd(BoardVO vo);
	
	public void likedislike(BoardVO vo);
}