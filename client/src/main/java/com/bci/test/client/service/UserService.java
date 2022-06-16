package com.bci.test.client.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bci.test.client.dto.UserDto;
import com.bci.test.client.entity.Phones;
import com.bci.test.client.entity.User;
import com.bci.test.client.repository.PhonesRepository;
import com.bci.test.client.repository.UserRepository;

@Service
public class UserService {

	 private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRerpository; 
	
	@Autowired
	private PhonesRepository phonesRepository;
	
	public User insertarNuevoUsuario(UserDto userDto) 
	{
		if(this.validateEmail(userDto.getEmail())) 
		{	
			
			if(userRerpository.validateMail(userDto.getEmail())==null) 
			{
				User user = new User();
				List<Phones> phoneList = new ArrayList<>();
				user.setUserName(userDto.getName());
				user.setEmail(userDto.getEmail());
				user.setPwd(userDto.getEmail());
				user.setCreatedDate(Date.valueOf(LocalDate.now()));
				user.setLastLoginDate(Date.valueOf(LocalDate.now()));
				user.setIsactiveStatus("ACTIVO");
				 userDto.getPhones().stream().forEach(x->{
						phoneList.add(new Phones(x.getNumber(), x.getCitycode(), x.getContrycode(), user));
					});
				user.setPhones(phoneList);
				User saveUser = userRerpository.save(user);
				phonesRepository.saveAll(user.getPhones());
				return saveUser;
				//return new UserDao(userRerpository.save(user));
			}else {
				logger.error("el mail ya existe");
			}
		}else {
			logger.error("el formato del mail no corresponde");
		}
			return null;
	}
	
	public User findById(int id) {
		return userRerpository.findById(id).orElseThrow(() -> new EntityNotFoundException("NO SE ENCONTRO USUARIO"));
	}
	
	private Boolean validateEmail(String email) {
		Pattern pattern = Pattern
				.compile("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");
		
		Matcher matcher = pattern.matcher(email);
		if(matcher.matches()){
			return true;
		}
		return false;
	}
}
