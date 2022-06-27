package com.sofkaU.software.virtualWallet.useCase.cuenta;

import com.sofkaU.software.virtualWallet.dto.CuentaDto;
import com.sofkaU.software.virtualWallet.mapper.CuentaMapper;
import com.sofkaU.software.virtualWallet.repository.ICuentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllCuentasUseCase {

    private final ICuentaRepository cuentaRepo;
    private final CuentaMapper mapper;

    public Flux<CuentaDto> todasLasCuentas(){
        return cuentaRepo.findAll().map(mapper::toCuentaDto);
    }

}
