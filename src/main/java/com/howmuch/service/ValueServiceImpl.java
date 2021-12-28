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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ValueVO> getList() {
		return mapper.getList();
	}

	@Override
	public List<ValueVO> register(ValueVO pri) {
		
		mapper.register(pri);
		return mapper.getList();
	}

//	@Override
//	public List<ValueVO> operation(int pri) {
//		
//		mapper.operation(pri);
//	
//		return mapper.operation(pri);
//	}

	@Override
	public List<ValueVO> avg(int pri) {
		mapper.avg(pri);
		return mapper.avg(pri);
	}


	@Override
	public List<LogVO> log(int bno) {
		mapper.log(bno);
		return mapper.log(bno);
	}

	@Override
	public List<CalculatorVO> min(int min) {
		mapper.min(min);
		return mapper.min(min);
	}

	@Override
	public List<CalculatorVO> max(int max) {
		mapper.max(max);
		return mapper.min(max);
	}

}
