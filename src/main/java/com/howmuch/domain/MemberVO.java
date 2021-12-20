package com.howmuch.domain;

import lombok.Data;

@Data
public class MemberVO {
	private int mno;
	private String email;
	private String nick;
	private String pw;
	private int point;
}
