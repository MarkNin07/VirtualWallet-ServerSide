package com.sofkaU.software.virtualWallet.routes;

import com.sofkaU.software.virtualWallet.dto.TransaccionDTO;
import com.sofkaU.software.virtualWallet.useCase.CreateTransaccionUseCase;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import org.springframework.context.annotation.Bean;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
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
                POST("/createTrans").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TransaccionDTO.class).flatMap(executor)
        );
    }
}
