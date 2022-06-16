package com.sistema.springbootapi.bci.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.springbootapi.bci.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Optional<Usuario> findByUsernameOrEmail(String username,String email);
}
