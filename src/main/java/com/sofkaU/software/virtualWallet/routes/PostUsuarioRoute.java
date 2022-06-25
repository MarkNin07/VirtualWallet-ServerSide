package com.sofkaU.software.virtualWallet.routes;

import com.sofkaU.software.virtualWallet.dto.UsuarioDto;
import com.sofkaU.software.virtualWallet.useCase.usuario.PostUsuarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostUsuarioRoute {

    @Bean
    public RouterFunction<ServerResponse> postBirthday(PostUsuarioUseCase useCase) {
        return route(POST("/post/user").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UsuarioDto.class)
                        .flatMap(useCase::createUsuario)
                        .flatMap(dto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(dto))
                        .onErrorResume((error) -> ServerResponse.status(HttpStatus.BAD_REQUEST).build())
        );
    }
}
