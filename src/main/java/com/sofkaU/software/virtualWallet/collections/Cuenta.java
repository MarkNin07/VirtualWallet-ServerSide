package com.sofkaU.software.virtualWallet.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "cuenta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta {

    @Id
    private String id;

    private String correoUsuario;

    private Long monto;

}
