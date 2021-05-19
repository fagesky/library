package org.fogsky.library.security;

import java.util.List;

import org.fogsky.library.model.User;
import org.fogsky.library.security.GetUser;
import org.fogsky.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserService us;
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder passwordEncoder =
			    PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return passwordEncoder;
	}
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests().antMatchers("/log","/borrowbook/*","/borrowbook").authenticated()
				.antMatchers("/adduser").hasAuthority("管理员").anyRequest().permitAll().and()
				.formLogin().and().logout().logoutUrl("/logout");
	}
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("test:"+us);
		auth.userDetailsService(new GetUser(us));
	}
	
}
