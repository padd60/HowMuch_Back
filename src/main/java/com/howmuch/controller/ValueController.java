package com.howmuch.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.howmuch.domain.BoardVO;
import com.howmuch.domain.CalculatorVO;
import com.howmuch.domain.LogVO;
import com.howmuch.domain.MemberVO;
import com.howmuch.domain.ValueVO;
import com.howmuch.service.BoardService;
import com.howmuch.service.MemberService;
import com.howmuch.service.ValueService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@CrossOrigin(origins = "*")
@RestController
@Log4j
public class ValueController {

	@Setter(onMethod_ = @Autowired)
	private ValueService service;

	@Setter(onMethod_ = @Autowired)
	private MemberService mservice;

	@Setter(onMethod_ = @Autowired)
	private BoardService bservice;

	@GetMapping("/ReadValueList")
	public @ResponseBody List<ValueVO> readList(ValueVO pri) {
		return service.getList(pri.getBno());
	}

	@PostMapping(value = "/RegisterValue")
	@PreAuthorize("isAuthenticated()")
	public @ResponseBody List<ValueVO> register(@RequestBody ValueVO pri, Principal principal) {
		
		BoardVO bvo = bservice.get(pri.getBno());
		
		MemberVO vo = mservice.read(principal.getName());
		
		if(bvo.getWriter().equals(vo.getNick())) {
			
			List<ValueVO> notList = new ArrayList<ValueVO>();
			
			ValueVO not = new ValueVO();
			not.setPrice(-1);
			
			notList.add(not);
			
			return notList;
		}

		pri.setMno(vo.getMno());
		pri.setRater(vo.getNick());

		log.info(pri.getPrice());
		log.info(pri.getBno());
		log.info(pri.getMno());
		log.info(pri.getRater());

		List<ValueVO> list = service.getList(pri.getBno());

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getRater().equals(pri.getRater())) {

				return null;
			}
		}
		return service.register(pri);
	}

	@GetMapping(value = "/log")
	public @ResponseBody List<LogVO> log(@RequestParam(value = "bno") int bno) {

		log.info("log.............." + bno);

		return service.log(bno);
	}

	@GetMapping(value = "/cal")
	public @ResponseBody CalculatorVO cal(@RequestParam(value = "bno") int bno) {

		CalculatorVO cal = service.cal(bno);

		cal.setAvg(Math.round(cal.getAvg()));

		return cal;
	}

	@GetMapping("/setPoint")
	@PreAuthorize("isAuthenticated()")
	public @ResponseBody CalculatorVO setpoint(BoardVO vo, Principal principal) {

		List<ValueVO> check = service.getList(vo.getBno());

		if (check.size() < 1) {
			CalculatorVO vvo = new CalculatorVO();
			vvo.setAvg(0);
			vvo.setMax(0);
			vvo.setMin(0);
			return vvo;
		}

		CalculatorVO cal = service.cal(vo.getBno());

		cal.setAvg(Math.round(cal.getAvg()));

		MemberVO user = mservice.read(principal.getName());

		BoardVO bvo = bservice.get(vo.getBno());

		if (user.getMno() != vo.getMno()) {
			return null;
		}

		double avg = cal.getAvg();

		if (avg >= 100000000) {
			int added = (int) (avg - 1000000) / 1000000;
			user.setPoint(100 + added);
		} else if (avg > 700000) {
			user.setPoint(100);
		} else if (avg > 500000) {
			user.setPoint(70);
		} else if (avg > 100000) {
			user.setPoint(50);
		} else if (avg > 50000) {
			user.setPoint(30);
		} else if (avg > 10000) {
			user.setPoint(20);
		} else {
			user.setPoint(10);
		}

		bvo.setEnd(1);

		bservice.checkEnd(bvo);

		mservice.setPoint(user);

		return cal;

	}

}
