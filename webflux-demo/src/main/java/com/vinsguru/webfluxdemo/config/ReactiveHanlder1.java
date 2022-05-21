package com.vinsguru.webfluxdemo.config;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;


@Service
public class ReactiveHanlder1 {
    public Mono<ServerResponse> processFish(ServerRequest request){
        String fishName = request.pathVariable("fishName");
        Flux<Fish> flux = Flux.range(1, 5)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(item -> System.out.println("Processing now " + item))
                .map(item -> new Fish(item, fishName + item, item));

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(flux,Fish.class);
    }
}
