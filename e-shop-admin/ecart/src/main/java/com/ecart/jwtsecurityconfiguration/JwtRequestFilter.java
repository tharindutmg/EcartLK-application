/**
 * 
 */
package com.ecart.jwtsecurityconfiguration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author Tharindu   Jan 28, 2020
 *
 */

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired 
	private MyUserDetailsServiceImpl myUserDetailsService;
	@Autowired 
	private JwtUtil jwtUtil;

	private String header = "Authorization";
	private String header2 = "authorization";
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String jwt=null;
		String userName=null;
		
		String authorizationHeader = request.getHeader(header);
		if(authorizationHeader==null) {
			authorizationHeader = request.getHeader(header2);
		}
		System.out.println(authorizationHeader);
		if (authorizationHeader!=null && authorizationHeader.startsWith("Bearer")){
			jwt=authorizationHeader.substring(7);
			userName= jwtUtil.getUsernameFromToken(jwt);
		}
		
		if ((userName!=null) && (SecurityContextHolder.getContext().getAuthentication() == null)){
			UserDetails userDetails = this.myUserDetailsService.loadUserByUsername(userName);
			boolean isValid=jwtUtil.validateToken(jwt,userDetails);
		if (isValid){
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
		}filterChain.doFilter(request,response);
	}
}
