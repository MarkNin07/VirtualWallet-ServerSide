package com.sofkaU.software.virtualWallet.useCase.transaccion;

import com.sofkaU.software.virtualWallet.dto.TransaccionDTO;
import com.sofkaU.software.virtualWallet.mapper.Mapper;
import com.sofkaU.software.virtualWallet.repository.TransaccionRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class GetAllTransaccionUseCase {

    private final TransaccionRepository transaccionRepository;
    private final Mapper mapper;

    public GetAllTransaccionUseCase(TransaccionRepository transaccionRepository, Mapper mapper) {
        this.transaccionRepository = transaccionRepository;
        this.mapper = mapper;
    }

    public Flux<TransaccionDTO> getAllTransaccion() {
        return transaccionRepository.findAll()
                .map(mapper.mapEntityToTransaccion());
    }

}
