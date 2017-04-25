package com.aptech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aptech.dao.UserDao;
import com.aptech.model.User;
import com.aptech.model.UserRole;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		User user = userDao.findByUsername(username);
		if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserroles());
		return buildUserForAuthentication(user, authorities);
	}

	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(List<UserRole> userroles) {
		List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		for (UserRole c : userroles) {
			auth.add(new SimpleGrantedAuthority(c.getRole()));
		}
		return auth;
	}

}
