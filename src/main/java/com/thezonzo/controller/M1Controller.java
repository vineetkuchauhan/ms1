package com.thezonzo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ms1")
public class M1Controller {

    @GetMapping(value = "/get-data")
    public Mono<String> getData(ServerHttpRequest request, ServerHttpResponse response){
        System.out.println("Inside MS1 get data");
        HttpHeaders httpHeaders = request.getHeaders();

        httpHeaders.forEach((k,v)-> {
            System.out.println(k + " " + v);
        });

        ResponseCookie.ResponseCookieBuilder builder = ResponseCookie.from("ms1-cookie", "ms1CookieValue");
        ResponseCookie cookie = builder.build();
        response.addCookie(cookie);

        return  Mono.just("Hello from reactive MS1 get data");
    }
}
