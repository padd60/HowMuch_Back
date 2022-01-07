package com.howmuch.domain;

import lombok.Data;

@Data
public class BoardLikeVO {
	private int cno;
	private int bno;
	private int mno;
	private int checklike;
	private int checkdislike;
}
