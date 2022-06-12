package com.bci.test.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bci.test.client.repository.UserRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService  {

	@Autowired
	private UserRepository userRepository;
	
  @Override
  public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {

	  if(userRepository.validateMail(mail)!=null) {
     	User.UserBuilder userBuilder = User.withUsername(mail);
     	String encryptedPassword = "$2a$10$56VCAiApLO8NQYeOPiu2De/EBC5RWrTZvLl7uoeC3r7iXinRR1iiq";
     	userBuilder.password(encryptedPassword);
     	return userBuilder.build();
	  } else {
	      throw new UsernameNotFoundException(mail);
	    }
 
  }
}
