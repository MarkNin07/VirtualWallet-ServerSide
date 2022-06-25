package com.sofkaU.software.virtualWallet.useCase.usuario;

import com.sofkaU.software.virtualWallet.collections.Usuario;
import com.sofkaU.software.virtualWallet.dto.UsuarioDto;
import com.sofkaU.software.virtualWallet.mapper.UsuarioMapper;
import com.sofkaU.software.virtualWallet.repository.iUsuarioRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllUsuariosUseCase {

    private final iUsuarioRepository repository;
    private final UsuarioMapper mapper;

    public GetAllUsuariosUseCase(iUsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Flux<UsuarioDto> getAllUsers(){
        return repository.findAll().map(entity -> {
            UsuarioDto usuarioDto = mapper.entityToDto(entity);
            usuarioDto.setContrasena("Hidden");
            return usuarioDto;
        });
    }
}