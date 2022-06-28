package com.sofkaU.software.virtualWallet.useCase.cuenta;

import com.sofkaU.software.virtualWallet.dto.CuentaDto;
import com.sofkaU.software.virtualWallet.mapper.CuentaMapper;
import com.sofkaU.software.virtualWallet.repository.ICuentaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
@Slf4j
public class GetAllCuentasUseCase {

    private final ICuentaRepository cuentaRepo;
    private final CuentaMapper mapper;

    public Flux<CuentaDto> todasLasCuentas() {
        return cuentaRepo.findAll().map(mapper::toCuentaDto)
                .onErrorResume(error -> {
                    log.error(error.getMessage());
                    return Flux.empty();
        });

    }

}
