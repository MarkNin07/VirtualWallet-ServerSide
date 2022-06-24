package com.sofkaU.software.virtualWallet.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "cuenta")
@Data
@AllArgsConstructor
public class Cuenta {

    @Id
    private String cuentaId;

    private String correoUsuario;

    private Long monto;

}
