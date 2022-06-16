package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "telefonos")
public class Telefonos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 12)
	private Integer numero;
	
	@Column(length = 5)
	private Integer codigoCiudad;
	
	@Column(length = 5)
	private Integer codigoPais;
	
	@ManyToOne
	@JoinColumn(name  = "fk_usuario_telefono")
	private Usuario usuario;
}
