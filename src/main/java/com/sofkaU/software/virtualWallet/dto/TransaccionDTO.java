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

    private String fecha;

    private String correoOrigen;

    private String correoDestino;

    private Long valor;
}
