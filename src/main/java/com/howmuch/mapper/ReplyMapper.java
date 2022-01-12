package com.howmuch.mapper;

import java.util.List;

import com.howmuch.domain.ReplyVO;

public interface ReplyMapper {
	
	public ReplyVO getData();
	
	public void insert(ReplyVO reply);

	public ReplyVO read(int rno);

	public void delete(ReplyVO reply);

	public int update(ReplyVO reply);
	
	public List<ReplyVO> getList(int bno);

	public void likedislike(ReplyVO vo);

	public ReplyVO getData(int rno);
	
	public void BoardDelete(int bno);

}
