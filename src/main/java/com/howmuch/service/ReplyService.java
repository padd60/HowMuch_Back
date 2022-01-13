package com.howmuch.service;

import java.util.List;

import com.howmuch.domain.BoardVO;
import com.howmuch.domain.ReplyVO;

public interface ReplyService {
	
	public ReplyVO get();
	
	public List<ReplyVO> getList(int bno);
	
	public ReplyVO update(ReplyVO reply);
	
	public List<ReplyVO> delete(ReplyVO reply);
	
	public List<ReplyVO> insert(ReplyVO reply);
	
	public void likedislike(ReplyVO vo);

	public ReplyVO get(int rno);
	
	public void BoardDelete(int bno);
	
	public void ReplyDelete(int rno);
}
