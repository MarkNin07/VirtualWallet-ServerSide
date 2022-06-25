package com.sofkaU.software.virtualWallet.mapper;

import com.sofkaU.software.virtualWallet.collections.Transaccion;
import com.sofkaU.software.virtualWallet.dto.TransaccionDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class Mapper {

    public Function<TransaccionDTO, Transaccion> mapperToTransaccion(String id){
        return updateTransaccion -> {
            var transaccion = new Transaccion();
            transaccion.setId(id);
            transaccion.setFecha(updateTransaccion.getFecha());
            transaccion.setCorreoOrigen(updateTransaccion.getCorreoOrigen());
            transaccion.setCorreoDestino(updateTransaccion.getCorreoDestino());
            transaccion.setValor(updateTransaccion.getValor());
            return transaccion;
        };
    }

    public Function<Transaccion, TransaccionDTO> mapEntityToTransaccion() {
        return entity -> new TransaccionDTO(
                entity.getId(), entity.getFecha(), entity.getCorreoOrigen(), entity.getCorreoDestino(), entity.getValor()
        );
    }
}
