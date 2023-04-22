package com.example.demo.Spring_Security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
@Override
protected void configure(HttpSecurity http) throws Exception {
	// TODO Auto-generated method stub
	http.authorizeRequests().antMatchers("/land/**").hasRole("NORMAL").antMatchers("/signin").permitAll().anyRequest().authenticated(). and().formLogin().loginPage("/signin").loginProcessingUrl("/dologin").defaultSuccessUrl("/land");
	                   
}
@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication().withUser("john").password(this.passwordEncoder().encode("1234")).roles("NORMAL");
	auth.inMemoryAuthentication().withUser("wick").password(this.passwordEncoder().encode("1234")).roles("ADMIN");

	}
@Bean
public PasswordEncoder passwordEncoder()
{
	return new BCryptPasswordEncoder(10);
}
}
