package com.sprinboot.webclient.service;

import com.sprinboot.webclient.dto.TopicDto;
import com.sprinboot.webclient.serviceInterface.TopicsSpringIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@Service
public class TopicsSpringService implements TopicsSpringIface {

    private final static String BASE_URL = "http://springbootwebflux:8090/springBootWebflux";

    @Autowired
    private WebClient webClient;

    public Flux<TopicDto> getAllTopicsDtos() {
        return this.webClient.get()
                .uri(BASE_URL, uriBuilder -> {
                    uriBuilder.path("/topics");
                    return uriBuilder.build();
                })
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->
                        Mono.error(new Exception("Damn! now this api is not working")))
                .onStatus(HttpStatus::is5xxServerError, clientResponse ->
                        Mono.error(new Exception("Damn! now this api is not working")))
                .bodyToFlux(TopicDto.class)
                .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(5)));
    }

    public Mono<TopicDto> getTopicDto(String id) {
        return this.webClient.get()
                .uri(BASE_URL, uriBuilder -> {
                    uriBuilder.path("/topics/" + id);
                    return uriBuilder.build();
                })
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->
                        Mono.error(new Exception("Damn! now this api is not working")))
                .onStatus(HttpStatus::is5xxServerError, clientResponse ->
                        Mono.error(new Exception("Damn! now this api is not working")))
                .bodyToMono(TopicDto.class)
                .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(5)));
    }

    public Mono<String> addTopicDto(TopicDto topicDto) {
        Mono<String> response = this.webClient.post()
                .uri(BASE_URL, uriBuilder -> {
                    uriBuilder.path("/topics/add");
                    return uriBuilder.build();
                })
                .body(Mono.just(topicDto), TopicDto.class)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->
                        Mono.error(new Exception("Damn! now this api is not working")))
                .onStatus(HttpStatus::is5xxServerError, clientResponse ->
                        Mono.error(new Exception("Damn! now this api is not working")))
                .bodyToMono(String.class)
                .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(5)));
        return response;
    }

    public Mono<String> updateTopicDto(TopicDto topicDto, String id) {
        Mono<String> response = this.webClient.put()
                .uri(BASE_URL, uriBuilder -> {
                    uriBuilder.path("/topics/update/" + id);
                    return uriBuilder.build();
                })
                .body(Mono.just(topicDto), TopicDto.class)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->
                        Mono.error(new Exception("Damn! now this api is not working")))
                .onStatus(HttpStatus::is5xxServerError, clientResponse ->
                        Mono.error(new Exception("Damn! now this api is not working")))
                .bodyToMono(String.class)
                .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(5)));
        return response;
    }

    public Mono<String> deleteTopic(String id) {
        Mono<String> response = this.webClient.delete()
                .uri(BASE_URL, uriBuilder -> {
                    uriBuilder.path("/topics/delete/" + id);
                    return uriBuilder.build();
                })
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->
                        Mono.error(new Exception("Damn! now this api is not working")))
                .onStatus(HttpStatus::is5xxServerError, clientResponse ->
                        Mono.error(new Exception("Damn! now this api is not working")))
                .bodyToMono(String.class)
                .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(5)));
        return response;
    }
}
