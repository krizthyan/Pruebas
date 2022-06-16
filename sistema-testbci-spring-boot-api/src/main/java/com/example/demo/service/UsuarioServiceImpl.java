package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RespuestaDto;
import com.example.demo.dto.UsuarioDto;
import com.example.demo.entity.Usuario;
import com.example.demo.mapper.UsuarioMapper;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.security.JwtTokenProvider;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	
	@Override
	public RespuestaDto crearUsuario(UsuarioDto usuarioDto) {
		
		
			Usuario save = usuarioRepository.save(usuarioMapper.usuarioDtoAUsuario(usuarioDto));
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuarioDto.getEmail(), usuarioDto.getPassword()));
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			String token = jwtTokenProvider.generarToken(authentication);
			RespuestaDto response = usuarioMapper.usuarioDtoARespuestaDto(save);
			response.setToken(token);
			if(save.getIsActive()!=0) {
				response.setIsactive(true);
			}else {
				response.setIsactive(false);
			}
		
			return response;
		
	}

}
