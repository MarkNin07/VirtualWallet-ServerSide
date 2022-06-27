package com.sofkaU.software.virtualWallet.routes.cuenta;

import com.sofkaU.software.virtualWallet.dto.CuentaDto;
import com.sofkaU.software.virtualWallet.useCase.cuenta.UpdateCuentaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateCuentaRoute {

    @Bean
    public RouterFunction<ServerResponse> actualizarCuenta(UpdateCuentaUseCase updCuenta){
        return route(PUT("/update/cuenta").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CuentaDto.class)
                        .flatMap(updCuenta::updateCuenta)
                        .flatMap(cuentaDto -> ServerResponse.status(HttpStatus.ACCEPTED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(cuentaDto))
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.BAD_REQUEST).build()));
    }
}
