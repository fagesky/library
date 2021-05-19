package org.fogsky.library.security;

import java.util.ArrayList;
import java.util.List;

import org.fogsky.library.model.User;
import org.fogsky.library.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class GetUser implements UserDetailsService{
	
		UserService us;
		public GetUser(UserService us) {
			this.us=us;
		}
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			// TODO Auto-generated method stub
			System.out.println("test:"+username);
			User user=us.getUser(username);
			if(user!=null) {
				List<GrantedAuthority> authorites=new ArrayList<GrantedAuthority>();
				authorites.add(new SimpleGrantedAuthority(user.getRole()));
				UserDetails userDetail=new  org.springframework.security.core.userdetails.User(user.getName(),
						user.getPassword(),authorites);
				return userDetail;
			}
			throw new UsernameNotFoundException("User '"+username+"' not found ");
		}
		
}
