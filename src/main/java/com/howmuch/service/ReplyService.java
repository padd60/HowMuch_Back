package com.howmuch.service;

import java.util.List;

import com.howmuch.domain.ReplyVO;

public interface ReplyService {

	public ReplyVO get();
	
	public List<ReplyVO> getList(int bno);
	
	public ReplyVO update(ReplyVO reply);
	
	public List<ReplyVO> delete(int rno, int bno);
	
	public List<ReplyVO> insert(ReplyVO reply);
}
