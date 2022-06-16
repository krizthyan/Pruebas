package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaDto {
	private Long id;
	private String name;
	private String email;
	private String password;
	private Date created;
	private Date modified;
	private Date last_login;
	private String token;
	private Boolean isactive;
	private List<PhonesDto> phones;
}
