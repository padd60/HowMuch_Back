package com.howmuch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howmuch.domain.BoardVO;
import com.howmuch.mapper.BoardMapper;

import lombok.Setter;

@Service
public class BoardServiceImpl implements BoardService {
	

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Override
	public BoardVO get() {

		return mapper.getData();
	}

	@Override
	public List<BoardVO> getList() {
		List<BoardVO> list = mapper.getList();
		
		if(list.size()<1) {
			return null;
		}
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTag() != "not") {
				list.get(i).setTagList(list.get(i).getTag().split(","));
			}
			if(list.get(i).getImage() != null) {
				list.get(i).setImageList(list.get(i).getImage().split("_"));
			}
		}
		
		return list;
	}
	
	public List<BoardVO> hotList() {

		List<BoardVO> list = mapper.hotList();
		
		if(list.size()<1) {
			return null;
		}
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTag() != "not") {
				list.get(i).setTagList(list.get(i).getTag().split(","));
			}
			if(list.get(i).getImage() != null) {
				list.get(i).setImageList(list.get(i).getImage().split("_"));
			}
		}
		
		return list;
	}

	@Override
	public List<BoardVO> update(BoardVO vo) {
		
		if(mapper.updateData(vo) < 1) {
			return null;
		}
		
		return getList();
	}

	@Override
	public List<BoardVO> register(BoardVO vo) {
		
		mapper.register(vo);
		
		return mapper.getList();
	}

	@Override
	public List<BoardVO> delete(int bno) {
		
		mapper.delete(bno);
		
		return mapper.getList();
	}
	
	@Override
	public void rcount(int bno) {
		mapper.rcount(bno);
	}

	@Override
	public List<BoardVO> getSearchList(String type, String keyword) {

		return mapper.selectSearchList(type, keyword);
	}
	
	@Override
    public void blike(int bno) {
       mapper.blike(bno);
    }
   
    @Override
    public void bdislike(int bno) {
       mapper.bdislike(bno);
    }

}
