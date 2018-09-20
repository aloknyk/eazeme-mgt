package com.yellp.security.jwtsecurity.userservice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.yellp.dao.UserRepository;
import com.yellp.entity.ApplicationUser;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	/*
	 * When a user tries to authenticate, this method receives the user name,
	 * searches the database for a record containing it, and (if found) returns an
	 * instance of User. The properties of this instance (user name and password) are
	 * then checked against the credentials passed by the user in the login request.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		ApplicationUser applicationUser = userRepository.findByUsername(username);
		if (applicationUser == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(applicationUser.getUsername(), applicationUser.getPassword(), new ArrayList<>());
	}
}
