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
        @NotBlank(message = "Por favor ingrese su nombre")
        private String nombre;
        @NotBlank(message = "Por favor ingrese su correo")
        private String correo;
        @NotBlank(message = "Por favor ingrese una contraseña")
        private String contrasena;
        private String rol;
        private boolean estaActivo;
        private boolean correoVerificado;

}
