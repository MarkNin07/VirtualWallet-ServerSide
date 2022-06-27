package com.sofkaU.software.virtualWallet.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Usuario")
public class Usuario {

    @Id
    private String id;
    private String nombre;
    private String correo;
    private String contrasena;
    private String rol;
    private boolean estaActivo;
    private boolean correoVerificado;


}
