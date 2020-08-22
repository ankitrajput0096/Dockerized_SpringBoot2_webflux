package com.sprinboot.webclient.controller;

import com.sprinboot.webclient.dto.TopicDto;
import com.sprinboot.webclient.service.TopicsSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/springBootWebClient")
public class TopicsSpringController {

    @Autowired
    private TopicsSpringService topicsSpringService;

    @RequestMapping(value = "/topics")
    public ResponseEntity<Flux<TopicDto>> listOfTopics() {
        return ResponseEntity.ok().body(
                this.topicsSpringService.getAllTopicsDtos());
    }

    @RequestMapping(value = "/topics/{id}")
    public ResponseEntity<Mono<TopicDto>> getRequiredTopic(
            @PathVariable String id) {
        return ResponseEntity.ok().body(
                this.topicsSpringService.getTopicDto(id));
    }

    //In this json object is sent
    /*
     * {
     * 		"topic_id":"java"
     * 		"topic_name":"java programming"
     * 		"topic_desc":"java is easy"
     * }
     */
    @RequestMapping(value = "/topics/add", method = RequestMethod.POST)
    public ResponseEntity<Mono<String>> addTopic(
            @RequestBody TopicDto topicDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.topicsSpringService.addTopicDto(topicDto));
    }

    @RequestMapping(value = "/topics/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Mono<String>> updateTopic(
            @RequestBody TopicDto topicDto, @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(this.topicsSpringService.updateTopicDto(topicDto, id));
    }

    //Url "localhost:8080/springBootJpa/topics/delete/java
    @RequestMapping(value = "/topics/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Mono<String>> deleteTopic(@PathVariable String id) {
        return ResponseEntity.ok().body(this.topicsSpringService.deleteTopic(id));
    }
}
