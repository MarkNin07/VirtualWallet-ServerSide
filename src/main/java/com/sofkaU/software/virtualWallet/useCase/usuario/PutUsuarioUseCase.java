package com.sofkaU.software.virtualWallet.useCase.usuario;

import com.sofkaU.software.virtualWallet.bcrypt.BcryptMapper;
import com.sofkaU.software.virtualWallet.dto.UsuarioDto;
import com.sofkaU.software.virtualWallet.mapper.UsuarioMapper;
import com.sofkaU.software.virtualWallet.repository.iUsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
public class PutUsuarioUseCase {

    private final iUsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final BcryptMapper bcrypt;

    public PutUsuarioUseCase(iUsuarioRepository repository, UsuarioMapper mapper, BcryptMapper bcrypt) {
        this.repository = repository;
        this.mapper = mapper;
        this.bcrypt = bcrypt;
    }

    public Mono<UsuarioDto> updateUsuarioUseCase(UsuarioDto dto){

        return repository.findByCorreo(dto.getCorreo())
                .switchIfEmpty(Mono.error(()-> new IllegalStateException("Usuario con correo " + dto.getCorreo() + " no encontrado")))
                .flatMap(userDto -> repository.save(mapper.dtoToEntity(dto)))
                .map(entity ->{
                    UsuarioDto usuarioDto = mapper.entityToDto(entity);
                    usuarioDto.setContrasena("Forbidden");
                    return usuarioDto;
                });
    }
}