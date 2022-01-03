package com.howmuch.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.howmuch.domain.MemberVO;
import com.howmuch.mapper.MemberMapper;
import com.howmuch.security.domain.CustomUser;

import lombok.Setter;
import lombok.extern.log4j.Log4j;



@Log4j
public class CustomUserDetailsService implements UserDetailsService {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper memberMapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MemberVO vo = memberMapper.read(username);
		
		log.warn("Queried by member mapper : " + vo);
		
		return vo == null ? null : new CustomUser(vo);
		
		
	}
	
}
