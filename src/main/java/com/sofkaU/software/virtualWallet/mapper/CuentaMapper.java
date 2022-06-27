package com.sofkaU.software.virtualWallet.mapper;


import com.sofkaU.software.virtualWallet.collections.Cuenta;
import com.sofkaU.software.virtualWallet.dto.CuentaDto;
import org.springframework.stereotype.Component;

@Component
public class CuentaMapper {

    public Cuenta toCuentaCollection(CuentaDto cuentaDto){
        Cuenta cuenta = new Cuenta();

        cuenta.setId(cuentaDto.getId());
        cuenta.setCorreoUsuario(cuentaDto.getCorreoUsuario());
        cuenta.setMonto(cuentaDto.getMonto());

        return cuenta;

    }

    public CuentaDto toCuentaDto(Cuenta cuenta){
        CuentaDto cuentaDto = new CuentaDto();

        cuentaDto.setId(cuenta.getId());
        cuentaDto.setCorreoUsuario(cuenta.getCorreoUsuario());
        cuentaDto.setMonto(cuenta.getMonto());

        return cuentaDto;

    }

}
