package com.howmuch.mapper;

import java.util.List;

import com.howmuch.domain.CalculatorVO;
import com.howmuch.domain.LogVO;
import com.howmuch.domain.ValueVO;

public interface ValueMapper {
	
	public ValueVO getData();
	
	public void register(ValueVO pri);
	
//	public List<ValueVO> operation(int pri);

	public List<ValueVO> getList();

	public List<ValueVO> avg(int pri);

	public List<LogVO> log(int bno);

	public List<CalculatorVO> min(int min);

	public List<CalculatorVO> max(int max);
	
}
