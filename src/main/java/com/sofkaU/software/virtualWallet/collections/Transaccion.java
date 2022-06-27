package com.sofkaU.software.virtualWallet.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Transaccion {

    @Id
    private String id;
    private String fecha;
    private String correoOrigen;
    private String correoDestino;
    private Long valor;
}
