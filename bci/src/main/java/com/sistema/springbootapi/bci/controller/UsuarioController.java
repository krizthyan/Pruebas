package com.sistema.springbootapi.bci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.springbootapi.bci.dto.ErrorDto;
import com.sistema.springbootapi.bci.dto.UsuarioDto;
import com.sistema.springbootapi.bci.service.UsuarioServiceImpl;
import com.sistema.springbootapi.bci.util.ValidarCorreoContrasenia;

@RestController
@RequestMapping(path= "/api/")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl serviceImpl;
	
	@Autowired
	private ValidarCorreoContrasenia validarCorreoContrasena;
	
	@PostMapping(path = "/auth")
	public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDto usuarioDto)
	{
		if(!validarCorreoContrasena.validaEmail(usuarioDto.getEmail())) 
		{
			
			return new ResponseEntity<>(new ErrorDto("el correo no cumple con el formato"), HttpStatus.BAD_REQUEST); 
		}
		
		if(!validarCorreoContrasena.validacontrasena(usuarioDto.getPassword())) {
			return new ResponseEntity<>(new ErrorDto("La contraseña debe contener una Mayuscula, letras minúsculas, y dos numeros"), HttpStatus.BAD_REQUEST); 
		}
		return new ResponseEntity<>(serviceImpl.crearUsuario(usuarioDto), HttpStatus.CREATED);
	}
}
