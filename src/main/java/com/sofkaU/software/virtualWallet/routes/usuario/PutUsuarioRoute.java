package com.sofkaU.software.virtualWallet.routes.usuario;

import com.sofkaU.software.virtualWallet.dto.UsuarioDto;
import com.sofkaU.software.virtualWallet.useCase.usuario.PutUsuarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PutUsuarioRoute {

    @Bean
    public RouterFunction<ServerResponse> putRoute(PutUsuarioUseCase useCase){

        return route(PUT("/put/user").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UsuarioDto.class)
                        .flatMap(useCase::updateUsuarioUseCase)
                        .flatMap(usuarioDto -> ServerResponse.status(HttpStatus.ACCEPTED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(usuarioDto))
                        .onErrorResume(throwable -> {
                            System.out.println(throwable.getMessage());
                            return ServerResponse.status(HttpStatus.BAD_REQUEST).build();
                        }));
    }
}
