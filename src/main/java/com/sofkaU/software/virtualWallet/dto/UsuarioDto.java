package com.sofkaU.software.virtualWallet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

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

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                UsuarioDto that = (UsuarioDto) o;
                return estaActivo == that.estaActivo && correoVerificado == that.correoVerificado && Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(correo, that.correo) && Objects.equals(rol, that.rol);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, nombre, correo, rol, estaActivo, correoVerificado);
        }
}
