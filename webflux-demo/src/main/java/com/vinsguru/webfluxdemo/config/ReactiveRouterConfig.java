package com.vinsguru.webfluxdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class ReactiveRouterConfig {

    @Autowired
    ReactiveHanlder1 reactiveHanlder1;
    @Bean
    public RouterFunction<ServerResponse> handleFishProcessing(ServerRequest request){

        return RouterFunctions.route()
                .GET("controller1/fish/{fishName}", (HandlerFunction<ServerResponse>) reactiveHanlder1.processFish(request))
                .build();

    }
}
