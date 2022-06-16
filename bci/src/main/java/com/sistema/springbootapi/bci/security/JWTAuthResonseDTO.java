package com.sistema.springbootapi.bci.security;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JWTAuthResonseDTO {

	private String tokenDeAcceso;
	private String tipoDeToken = "Bearer";

	public JWTAuthResonseDTO(String tokenDeAcceso) {
		super();
		this.tokenDeAcceso = tokenDeAcceso;
	}
	
}
