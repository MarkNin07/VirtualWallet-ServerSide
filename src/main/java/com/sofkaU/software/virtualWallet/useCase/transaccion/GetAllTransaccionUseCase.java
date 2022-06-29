package com.sofkaU.software.virtualWallet.useCase.transaccion;

/**
 * Esta clase GetAllCuentasUseCase es el caso de uso que permite mostrar en pantalla todas las transacciones
 * que han sido creadas
 * @author: Marco Nino
 * */

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

    /**
     * El método getAllTransaccion retorna un Flux de DTO con todos las transacciones
     * luego de convertir cada colección de transacción en DTO
     * */

    public Flux<TransaccionDTO> getAllTransaccion() {
        return transaccionRepository.findAll()
                .map(mapper.mapEntityToTransaccion());
    }

}
