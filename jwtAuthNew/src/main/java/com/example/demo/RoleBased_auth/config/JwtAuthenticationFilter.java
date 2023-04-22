package com.example.demo.RoleBased_auth.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.RoleBased_auth.helper.JwtUtil;
import com.example.demo.RoleBased_auth.service.CustomUserDetails;

@Service
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	@Autowired
private JwtUtil jwtUtil;
	@Autowired
	private CustomUserDetails customUserDetails;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
				String authorization=request.getHeader("Authorization");
				String username=null;
				String JwtToken=null;
				if(authorization!=null&&authorization.startsWith("Bearer"))
				{
					JwtToken=authorization.substring(7);
					try
					{
						username=jwtUtil.extractUsername(JwtToken);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					UserDetails userDetails=customUserDetails.loadUserByUsername(username);
					
					if(username!=null&&SecurityContextHolder.getContext().getAuthentication()==null)
					{
						UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
						usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
					}
					
				}
				
				filterChain.doFilter(request, response);
	}

}
