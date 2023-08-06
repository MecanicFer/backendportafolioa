/*
package com.portafolioa.backendportafolioa.service.impl;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.portafolioa.backendportafolioa.entity.Rol;
import com.portafolioa.backendportafolioa.entity.Usuario;
import com.portafolioa.backendportafolioa.model.UsuarioRegistroDTO;
import com.portafolioa.backendportafolioa.repository.UsuarioRepositorio;
import com.portafolioa.backendportafolioa.service.UsuarioServicio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {
	
	private UsuarioRepositorio usuarioRepositorio;

	public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	public Usuario save(UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getNombre(), registroDTO.getApellido(), registroDTO.getEmail(), registroDTO.getPassword(), Arrays.asList(new Rol("ROLE_USER")));
		return usuarioRepositorio.save(usuario);
	}

}
*/