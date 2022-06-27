package com.sofkaU.software.virtualWallet.useCase;

import com.sofkaU.software.virtualWallet.dto.CuentaDto;
import com.sofkaU.software.virtualWallet.mapper.CuentaMapper;
import com.sofkaU.software.virtualWallet.repository.ICuentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class PostCuentaUseCase {

    private final ICuentaRepository cuentaRepo;

    private final CuentaMapper mapper;

    private boolean validarCamposCuenta(CuentaDto cuentaDto) {
        return cuentaDto.getCorreoUsuario() != null && cuentaDto.getMonto() != null;
    }

    private Mono<CuentaDto> filtrarCuentaConCamposNoNulos(CuentaDto cuentaDto){
        return Mono.just(cuentaDto)
                .filter(this::validarCamposCuenta)
                .switchIfEmpty(Mono.error(() -> new Throwable("Algunos campos están vacíos")));
    }

    public Mono<CuentaDto> crearCuenta(CuentaDto cuentaDto){
        return filtrarCuentaConCamposNoNulos(cuentaDto)
                .flatMap(cuentaDto1 -> cuentaRepo.save(mapper.toCuentaCollection(cuentaDto1)))
                .map(cuenta -> mapper.toCuentaDto(cuenta));
    }
}
