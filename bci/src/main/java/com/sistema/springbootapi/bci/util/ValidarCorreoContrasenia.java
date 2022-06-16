package com.sistema.springbootapi.bci.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class ValidarCorreoContrasenia {

	public Boolean validaEmail(String mail) {
		
		Pattern pattern = Pattern.compile("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");
		Matcher matcher = pattern.matcher(mail);
		return  matcher.find();
		
	}
	
public Boolean validacontrasena(String pwd) {
		
		Pattern pattern = Pattern.compile("^[A-Z]{1}+[a-z]+[0-9]{0,2}$");
		Matcher matcher = pattern.matcher(pwd);
		return  matcher.find();
		
	}
}
