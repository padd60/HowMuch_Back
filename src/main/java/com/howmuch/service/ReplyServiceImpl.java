package com.howmuch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.howmuch.domain.ReplyVO;
import com.howmuch.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	private ReplyMapper mapper;

	@Override
	public ReplyVO get() {
		return mapper.getData();
	}

	@Override
	public List<ReplyVO> getList(int bno) {
		return mapper.getList(bno);
	}

	@Override
	public ReplyVO update(ReplyVO reply) {
		if(mapper.update(reply) < 1 ) {
	         return null;
	      };
	      return mapper.getData();
	}

	@Override
	public List<ReplyVO> delete(ReplyVO reply) {
	
		mapper.delete(reply);
	      return mapper.getList(reply.getBno());
	   }

	@Override
	public List<ReplyVO> insert(ReplyVO reply) {

		mapper.insert(reply);
	      return mapper.getList(reply.getBno());
	}

	@Override
	public void likedislike(ReplyVO vo) {
		mapper.likedislike(vo);
		
	}

	@Override
	public ReplyVO get(int rno) {
		
		return mapper.getData(rno);
	}

	@Override
	public void BoardDelete(int bno) {
		
		mapper.BoardDelete(bno);
		
	}

	@Override
	public void ReplyDelete(int rno) {
		
		mapper.ReplyDelete(rno);
		
	}
}
