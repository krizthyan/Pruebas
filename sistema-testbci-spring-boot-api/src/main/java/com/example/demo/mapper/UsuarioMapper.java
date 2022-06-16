package com.example.demo.mapper;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PhonesDto;
import com.example.demo.dto.RespuestaDto;
import com.example.demo.dto.UsuarioDto;
import com.example.demo.entity.Telefonos;
import com.example.demo.entity.Usuario;

@Service
public class UsuarioMapper {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private List<PhonesDto> phoneAPhoneDto(List<Telefonos> telefonos){
		
		List<PhonesDto> phoneListDto = new ArrayList<>();
		
		telefonos.stream().forEach(x->{
			PhonesDto phonesDto = new PhonesDto();
			phonesDto.setNumber(x.getNumero());
			phonesDto.setCityCode(x.getCodigoCiudad());
			phonesDto.setContryCode(x.getCodigoPais());
			phoneListDto.add(phonesDto);
		});
		return phoneListDto;
	}
	
	private List<Telefonos> phoneDtoATelefono(List<PhonesDto> telefonos){
		
		List<Telefonos> listTel = new ArrayList<>();
		
		telefonos.stream().forEach(x->{
			Telefonos telef = new Telefonos();
			telef.setNumero(x.getNumber());
			telef.setCodigoCiudad(x.getCityCode());
			telef.setCodigoPais(x.getContryCode());
			listTel.add(telef);
		});
		return listTel;
	}
	
	public UsuarioDto usuarioAusuarioDto(Usuario usuario) {
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setId(usuario.getId());
		usuarioDto.setName(usuario.getUsername());
		usuarioDto.setPassword(usuario.getPassword());
		usuarioDto.setPhones(this.phoneAPhoneDto(usuario.getTelefonos()));
		return usuarioDto;
	}
	
	public Usuario usuarioDtoAUsuario(UsuarioDto usuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setUsername(usuarioDto.getName());
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));
		usuario.setCreatedDate(Date.valueOf(LocalDate.now()));
		usuario.setLastLogin(Date.valueOf(LocalDate.now()));
		usuario.setModifiedDate(Date.valueOf(LocalDate.now()));
		usuario.setTelefonos(this.phoneDtoATelefono(usuarioDto.getPhones()));
		usuario.setIsActive(1);
		return usuario;
	}
	
	public RespuestaDto usuarioDtoARespuestaDto(Usuario usuario) {
		RespuestaDto respuestaDto = new RespuestaDto();
		respuestaDto.setId(usuario.getId());
		respuestaDto.setName(usuario.getUsername());
		respuestaDto.setEmail(usuario.getEmail());
		respuestaDto.setPassword(usuario.getPassword());
		respuestaDto.setCreated(Date.valueOf(LocalDate.now()));
		respuestaDto.setLast_login(Date.valueOf(LocalDate.now()));
		respuestaDto.setModified(Date.valueOf(LocalDate.now()));
		respuestaDto.setToken(null);
		respuestaDto.setIsactive(null);
		respuestaDto.setPhones(this.phoneAPhoneDto(usuario.getTelefonos()));
		
		return respuestaDto;
	}
}
