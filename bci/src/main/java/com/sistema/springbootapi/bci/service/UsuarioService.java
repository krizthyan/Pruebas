package com.sistema.springbootapi.bci.service;

import com.sistema.springbootapi.bci.dto.RespuestaDto;
import com.sistema.springbootapi.bci.dto.UsuarioDto;

public interface UsuarioService {

	public RespuestaDto crearUsuario(UsuarioDto usuarioDto);
	
}
