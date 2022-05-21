package com.vinsguru.webfluxdemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("controller1")
public class ReactiveController1 {

    @GetMapping(value="dept/{deptId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> findPersonsUsingDepartment(@PathVariable long deptId){
       return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("processing now "+i))
                .map(i -> new Person(i,deptId,"user "+i));
    }
}
