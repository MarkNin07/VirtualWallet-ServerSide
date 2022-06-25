package com.sofkaU.software.virtualWallet.useCase;

import com.sofkaU.software.virtualWallet.dto.TransaccionDTO;
import com.sofkaU.software.virtualWallet.mapper.Mapper;
import com.sofkaU.software.virtualWallet.repository.TransaccionRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class GetAllTransaccionByCorreoUseCase {

    private final TransaccionRepository transaccionRepository;
    private final Mapper mapper;

    public GetAllTransaccionByCorreoUseCase(TransaccionRepository transaccionRepository, Mapper mapper) {
        this.transaccionRepository = transaccionRepository;
        this.mapper = mapper;
    }

    public Flux<TransaccionDTO> getAllTransaccionEgreso(String correo) {
        return transaccionRepository.findByCorreoOrigen(correo)
                .map(mapper.mapEntityToTransaccion());
    }

    public Flux<TransaccionDTO> getAllTransaccionIngreso(String correo) {
        return transaccionRepository.findByCorreoDestino(correo)
                .map(mapper.mapEntityToTransaccion());
    }
}
