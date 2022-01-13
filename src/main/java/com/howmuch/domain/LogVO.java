package com.howmuch.domain;

import java.util.Date;

import lombok.Data;

@Data
public class LogVO {
	
	private int bno;
	private String rater;
	private long price;
	private Date vdate;
	
	private int point;
}
