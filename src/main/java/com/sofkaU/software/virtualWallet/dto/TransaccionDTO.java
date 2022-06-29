package com.sofkaU.software.virtualWallet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransaccionDTO {

    private String id;
    @NotBlank(message = "Campo Fecha obligatorio")
    @Pattern(regexp = "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})(\\s)([0-1][0-9]|2[0-3])(:)([0-5][0-9])(:)([0-5][0-9])$", message = "Este campo no coincide con un formato de fecha valido")
    private String fecha;
    @NotBlank(message = "Campo Correo Origen obligatorio")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'\\*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Este campo no coincide con un formato de correo electronico valido")
    private String correoOrigen;
    @NotBlank(message = "Campo Correo Destino obligatorio")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'\\*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Este campo no coincide con un formato de correo electronico valido")
    private String correoDestino;
    @NotNull
    @Digits(integer = 12, fraction = 0, message = " El valor de la transaccion debe tener un numero entero de 12 digitos")
    @Min(value = 1, message = "No puede Transferir cantidades inferiores a 1")
    private Long valor;
}
