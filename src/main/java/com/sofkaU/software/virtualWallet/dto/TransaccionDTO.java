package com.sofkaU.software.virtualWallet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransaccionDTO {

    private String id;
    @NotBlank(message = "Campo Fecha obligatorio")
    private String fecha;
    @NotBlank(message = "Campo Correo Origen obligatorio")
    private String correoOrigen;
    @NotBlank(message = "Campo Correo Destino obligatorio")
    private String correoDestino;
    @NotBlank(message = "Campo Valor obligatorio")
    private Long valor;
}
