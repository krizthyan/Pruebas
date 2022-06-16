package com.sistema.springbootapi.bci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sistema.springbootapi.bci.dto.RespuestaDto;
import com.sistema.springbootapi.bci.dto.UsuarioDto;
import com.sistema.springbootapi.bci.entity.Usuario;
import com.sistema.springbootapi.bci.mapper.UsuarioMapper;
import com.sistema.springbootapi.bci.repository.UsuarioRepository;
import com.sistema.springbootapi.bci.security.JwtTokenProvider;

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
