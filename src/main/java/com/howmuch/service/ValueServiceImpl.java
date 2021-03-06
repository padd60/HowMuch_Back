package com.howmuch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howmuch.domain.CalculatorVO;
import com.howmuch.domain.LogVO;
import com.howmuch.domain.ValueVO;
import com.howmuch.mapper.ValueMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ValueServiceImpl implements ValueService {
	
	@Setter(onMethod_ = @Autowired)
	private ValueMapper mapper;
	
	@Override
	public ValueVO get() {
		
		return null;
	}

	@Override
	public List<ValueVO> getList(int bno) {
		return mapper.getList(bno);
	}

	@Override
	public List<ValueVO> register(ValueVO pri) {
		
		mapper.register(pri);
		return mapper.getList(pri.getBno());
	}

	@Override
	public CalculatorVO cal(int bno) {
		
		return mapper.cal(bno);
	}


	@Override
	public List<LogVO> log(int bno) {
		mapper.log(bno);
		return mapper.log(bno);
	}

	@Override
	public void BoardDelete(int bno) {
		
		mapper.BoardDelete(bno);
		
		
	}

	

}

