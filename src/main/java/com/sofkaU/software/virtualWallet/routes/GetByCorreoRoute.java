package com.sofkaU.software.virtualWallet.routes;

import com.sofkaU.software.virtualWallet.useCase.usuario.FindByCorreoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;


@Configuration
public class GetByCorreoRoute {

    @Bean
    public RouterFunction<ServerResponse> GetOneUser(FindByCorreoUseCase useCase){
        return route(GET("/getbyemail/user/{correo}"),
                request -> useCase.findByCorreo(request.pathVariable("correo"))
                        .flatMap(usuarioDto -> ServerResponse.status(HttpStatus.OK)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(usuarioDto))
                        .onErrorResume(throwable -> {
                            System.out.println(throwable.getMessage());
                            return ServerResponse.status(HttpStatus.NOT_FOUND).build();
                        }));
    }
}
