package com.howmuch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.howmuch.domain.BoardVO;
import com.howmuch.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@CrossOrigin(origins = "*")
@RestController
@Log4j
public class BoardController {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@GetMapping("/read")
	public @ResponseBody BoardVO read() {
		return service.get();
	}
	
	@GetMapping("/readList")
	public @ResponseBody List<BoardVO> readList(){
		
		return service.getList();
	}
	
	@PostMapping(value="/update")
	public @ResponseBody List<BoardVO> update(@RequestBody BoardVO vo) {

		return service.update(vo);
	}
	
	@PostMapping(value="/register")
	public @ResponseBody List<BoardVO> register(@RequestBody BoardVO vo){
		
		return service.register(vo);
	}
	
	@DeleteMapping(value="/delete")
	public @ResponseBody List<BoardVO> delete(@RequestParam(value="bno") int bno){
		
		return service.delete(bno);
		
	}
	
	@GetMapping("/getSearchList")
	public @ResponseBody List<BoardVO> getSearchList(@RequestParam("type") String type, @RequestParam("keyword") String keyword) {
		BoardVO vo = new BoardVO();
		
		vo.setType(type);
		vo.setKeyword(keyword);
		return service.getSearchList();
	}
	
	
}
