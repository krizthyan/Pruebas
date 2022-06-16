package com.sistema.springbootapi.bci.dto;

import java.util.List;

import lombok.Data;

@Data
public class UsuarioDto {

	private Long id;
	private String name;
	private String email;
	private String password;
	private List<PhonesDto> phones;
}
