package com.yellp.security;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yellp.entity.Client;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Autowired
	private AuthenticationManager authenticationManager;

	/* parse the credentials and pass it to the authentication manager for authentication */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			Client client = new ObjectMapper().readValue(request.getInputStream(), Client.class);

			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(client.getUserName(),
					client.getPassword(), new ArrayList<>());
			return authenticationManager.authenticate(token);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * this method is called on successful authentication and is used to generate
	 * "JWT" token using helper class JWT
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String token = JWT.create().withSubject(((User) authResult.getPrincipal()).getUsername())
				.sign(HMAC512(SecurityConstants.SECRET.getBytes()));
		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
	}

}
