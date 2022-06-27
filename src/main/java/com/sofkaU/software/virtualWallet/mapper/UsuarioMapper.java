package com.sofkaU.software.virtualWallet.mapper;

import com.sofkaU.software.virtualWallet.collections.Usuario;
import com.sofkaU.software.virtualWallet.dto.UsuarioDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class UsuarioMapper {

    public UsuarioDto entityToDto(Usuario usuario){

        UsuarioDto dto = new UsuarioDto();

        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setCorreo(usuario.getCorreo());
        dto.setContrasena(usuario.getContrasena());
        dto.setRol(usuario.getRol());
        dto.setEstaActivo(usuario.isEstaActivo());
        dto.setCorreoVerificado(usuario.isCorreoVerificado());

        return dto;
    }

    public Usuario dtoToEntity(UsuarioDto dto){

        Usuario usuario = new Usuario();

        usuario.setId(dto.getId());
        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getCorreo());
        usuario.setContrasena(dto.getContrasena());
        usuario.setRol(dto.getRol());
        usuario.setEstaActivo(dto.isEstaActivo());
        usuario.setCorreoVerificado(dto.isCorreoVerificado());

        return usuario;
    }
}
