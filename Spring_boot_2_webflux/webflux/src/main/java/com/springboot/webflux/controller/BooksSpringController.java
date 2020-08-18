package com.springboot.webflux.controller;

import com.springboot.webflux.dto.BookDto;
import com.springboot.webflux.dto.TopicDto;
import com.springboot.webflux.service.BooksAndTopicsSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/springBootWebflux")
public class BooksSpringController {

    @Autowired
    private BooksAndTopicsSpringService booksAndTopicsSpringService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Mono<String>> helloMethod() {
        return ResponseEntity.ok().body(Mono.just("hello friends"));
    }

    @RequestMapping(value = "/topics")
    public ResponseEntity<Flux<TopicDto>> listOfTopics() {
        return ResponseEntity.ok().body(Flux.fromIterable(this.booksAndTopicsSpringService.getAllTopicsDtos()));
    }

    @RequestMapping(value = "/topics/{id}")
    public ResponseEntity<Mono<TopicDto>> getRequiredTopic(@PathVariable String id) {
        return ResponseEntity.ok().body(Mono.just(this.booksAndTopicsSpringService.getTopicDto(id)));
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
    public ResponseEntity<Mono<String>> addTopic(@RequestBody TopicDto topicDto) {
        this.booksAndTopicsSpringService.addTopicDto(topicDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Mono.just("the new topic is created with details :" + topicDto.toString()));
    }

    @RequestMapping(value = "/topics/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Mono<String>> updateTopic(@RequestBody TopicDto topicDto, @PathVariable String id) {
        this.booksAndTopicsSpringService.updateTopicDto(topicDto, id);
        return ResponseEntity.status(HttpStatus.FOUND).body(Mono.just("the existing topic is updated with details :" + topicDto.toString()));
    }

    //Url "localhost:8080/springBootJpa/topics/delete/java
    @RequestMapping(value = "/topics/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Mono<String>> deleteTopic(@PathVariable String id) {
        this.booksAndTopicsSpringService.deleteTopic(id);
        return ResponseEntity.ok().body(Mono.just("the topic is successfully deleted with id : " + id));
    }

    //Url "localhost:8080/springBootJpa/topics/getById?id=java
    @RequestMapping(value = "/topics/getById", method = RequestMethod.GET)
    public ResponseEntity<Mono<TopicDto>> getById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok().body(Mono.just(this.booksAndTopicsSpringService.getByIdDto(id)));
    }

    @RequestMapping(value = "/topics/getByIdAndName", method = RequestMethod.GET)
    public ResponseEntity<Mono<TopicDto>> getByIdAndName(@RequestParam(value = "id") String id, @RequestParam(value = "name") String name) {
        return ResponseEntity.ok().body(Mono.just(this.booksAndTopicsSpringService.getByIdAndNameDto(id, name)));
    }


    @RequestMapping(value = "/books")
    public ResponseEntity<Flux<BookDto>> listOfBooks() {
        return ResponseEntity.ok().body(Flux.fromIterable(this.booksAndTopicsSpringService.getAllBookDtos()));
    }

    @RequestMapping(value = "/books/{id}")
    public ResponseEntity<Mono<BookDto>> getRequiredBook(@PathVariable String id) {
        return ResponseEntity.ok().body(Mono.just(this.booksAndTopicsSpringService.getBookDto(id)));
    }

    //In this json object is sent
    /*
     * {
     * 		"book_id":"java_book"
     * 		"book_name":"java programming book"
     * }
     */
    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public ResponseEntity<Mono<String>> addBook(@RequestBody BookDto bookDto) {
        this.booksAndTopicsSpringService.addBookDto(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Mono.just("the new book is created with details :" + bookDto.toString()));
    }

    @RequestMapping(value = "/books/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Mono<String>> updateBook(@RequestBody BookDto bookDto, @PathVariable String id) {
        this.booksAndTopicsSpringService.updateBookDto(bookDto, id);
        return ResponseEntity.status(HttpStatus.FOUND).body(Mono.just("the existing book is updated with details :" + bookDto.toString()));
    }

    //Url "localhost:8080/springBootJpa/books/delete/java
    @RequestMapping(value = "/books/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Mono<String>> deleteBook(@PathVariable String id) {
        this.booksAndTopicsSpringService.deleteBook(id);
        return ResponseEntity.ok().body(Mono.just("the book is successfully deleted with id : " + id));
    }
}
