package com.sofkaU.software.virtualWallet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDto {

    private String cuentaId;

    private String correoUsuario;

    private Long monto;

}
