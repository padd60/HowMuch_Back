package com.howmuch.mapper;

import java.util.List;

import com.howmuch.domain.ReplyVO;

public interface ReplyMapper {
	
	public ReplyVO getData();
	
	public void insert(ReplyVO reply);

	public ReplyVO read(int rno);

	public void delete(int rno, int bno);

	public int update(ReplyVO reply);
	
	public List<ReplyVO> getList(int bno);

}
