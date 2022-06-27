package com.sofkaU.software.virtualWallet.useCase.usuario;

import com.sofkaU.software.virtualWallet.collections.Usuario;
import com.sofkaU.software.virtualWallet.dto.UsuarioDto;
import com.sofkaU.software.virtualWallet.mapper.UsuarioMapper;
import com.sofkaU.software.virtualWallet.repository.iUsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Slf4j
public class GetAllUsuariosUseCase {

    private final iUsuarioRepository repository;
    private final UsuarioMapper mapper;

    public GetAllUsuariosUseCase(iUsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Flux<UsuarioDto> getAllUsers(){
        return repository.findAll()
                .map(entity -> {
            UsuarioDto usuarioDto = mapper.entityToDto(entity);
            usuarioDto.setContrasena("Hidden");
            return usuarioDto;
        }).onErrorResume(error-> {
                    log.error(error.getMessage());
                    return Flux.empty();
                });
    }
}
