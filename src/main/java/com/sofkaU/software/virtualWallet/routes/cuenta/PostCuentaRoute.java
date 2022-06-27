package com.sofkaU.software.virtualWallet.routes.cuenta;


import com.sofkaU.software.virtualWallet.dto.CuentaDto;
import com.sofkaU.software.virtualWallet.useCase.cuenta.PostCuentaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Service
public class PostCuentaRoute {

    @Bean
    public RouterFunction<ServerResponse> crearCuenta(PostCuentaUseCase postCuenta){
        return route(POST("/create/cuenta").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CuentaDto.class)
                        .flatMap(postCuenta::crearCuenta)
                        .flatMap(cuentaDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(cuentaDto))
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.BAD_REQUEST).build()));
    }
}
