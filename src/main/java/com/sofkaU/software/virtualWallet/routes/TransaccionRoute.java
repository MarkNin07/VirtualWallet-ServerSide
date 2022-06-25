package com.sofkaU.software.virtualWallet.routes;

import com.sofkaU.software.virtualWallet.dto.TransaccionDTO;
import com.sofkaU.software.virtualWallet.useCase.CreateTransaccionUseCase;
import com.sofkaU.software.virtualWallet.useCase.GetAllTransaccionByCorreoUseCase;
import com.sofkaU.software.virtualWallet.useCase.GetAllTransaccionUseCase;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import org.springframework.context.annotation.Bean;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
@Configuration
public class TransaccionRoute {

    @Bean
/*    annotattion swagger*/
    public RouterFunction<ServerResponse> createTransaccion(CreateTransaccionUseCase createTransaccionUseCase) {
        Function<TransaccionDTO, Mono<ServerResponse>> executor = transaccionDTO -> createTransaccionUseCase.apply(transaccionDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));

        return route(
                POST("/createTransaccion").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TransaccionDTO.class).flatMap(executor)
        );
    }

    @Bean
    /*    annotattion swagger*/
    public RouterFunction<ServerResponse> getAllTransaccion(GetAllTransaccionUseCase getAllTransaccionUseCase) {
        return route(GET("/getAllTransaccion"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllTransaccionUseCase.getAllTransaccion(), TransaccionDTO.class))
        );
    }

    @Bean
    /*    annotattion swagger*/
    public RouterFunction<ServerResponse> getAllTransaccionEgresoByCorreo(GetAllTransaccionByCorreoUseCase getAllTransaccionByCorreo) {
        return route(GET("/getAllTransaccionEgreso/user/{correo}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllTransaccionByCorreo.getAllTransaccionEgreso(request.pathVariable("correo")), TransaccionDTO.class))
        );
    }

    @Bean
    /*    annotattion swagger*/
    public RouterFunction<ServerResponse> getAllTransaccionIngresoByCorreo(GetAllTransaccionByCorreoUseCase getAllTransaccionByCorreo) {
        return route(GET("/getAllTransaccionIngreso/user/{correo}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllTransaccionByCorreo.getAllTransaccionIngreso(request.pathVariable("correo")), TransaccionDTO.class))
        );
    }
}
