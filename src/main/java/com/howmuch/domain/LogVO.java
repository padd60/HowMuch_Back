package com.howmuch.domain;

import java.util.Date;

import lombok.Data;

@Data
public class LogVO {
	
	private int bno;
	private String rater;
	private int price;
	private Date vdate;
}
