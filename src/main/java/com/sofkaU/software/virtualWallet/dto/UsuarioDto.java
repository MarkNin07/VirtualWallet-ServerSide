package com.sofkaU.software.virtualWallet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
public class UsuarioDto {

        private String id;
        @NotBlank
        private String nombre;
        @NotBlank
        private String correo;
        @NotBlank
        private String contrasena;
        private String rol;
        private boolean estaActivo;
        private boolean correoVerificado;

}
