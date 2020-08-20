package com.sprinboot.webclient.serviceInterface;

import com.sprinboot.webclient.dto.TopicDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TopicsSpringIface {

    Flux<TopicDto> getAllTopicsDtos();

    Mono<TopicDto> getTopicDto(String id);

    Mono<String> addTopicDto(TopicDto topicDto);

    Mono<String> updateTopicDto(TopicDto topicDto, String id);

    Mono<String> deleteTopic(String id);
}
