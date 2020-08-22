package com.springboot.webflux.service;

import com.springboot.webflux.bo.BookBo;
import com.springboot.webflux.bo.TopicBo;
import com.springboot.webflux.dto.BookDto;
import com.springboot.webflux.dto.TopicDto;
import com.springboot.webflux.mappers.impl.BookDtoBoMapper;
import com.springboot.webflux.mappers.impl.TopicDtoBoMapper;
import com.springboot.webflux.serviceInterface.BooksAndTopicsSpringIface;
import com.springboot.webflux.serviceInterface.DataManagerBook;
import com.springboot.webflux.serviceInterface.DataManagerTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksAndTopicsSpringService
        implements BooksAndTopicsSpringIface {

    @Autowired
    private DataManagerTopic dataManagerTopic;

    @Autowired
    private DataManagerBook dataManagerBook;

    @Autowired
    private TopicDtoBoMapper topicDtoBoMapper;

    @Autowired
    private BookDtoBoMapper bookDtoBoMapper;

    public List<TopicBo> getAllTopics() {
        return this.dataManagerTopic.getAllTopics();
    }

    public List<TopicDto> getAllTopicsDtos() {
        return this.getAllTopics().stream()
                .map(e -> this.topicDtoBoMapper.toDto(e))
                .collect(Collectors.toList());
    }

    public TopicBo getTopic(String id) {
        return this.dataManagerTopic.getTopic(id);
    }

    public TopicDto getTopicDto(String id) {
        return this.topicDtoBoMapper.toDto(this.getTopic(id));
    }

    public void addTopic(TopicBo topicBo) {
        this.dataManagerTopic.addTopic(topicBo);
    }

    public void addTopicDto(TopicDto topicDto) {
        this.addTopic(this.topicDtoBoMapper.toBo(topicDto));
    }

    public void updateTopic(TopicBo topicBo, String id) {
        this.dataManagerTopic.updateTopic(topicBo, id);
    }

    public void updateTopicDto(TopicDto topicDto, String id) {
        this.updateTopic(this.topicDtoBoMapper.toBo(topicDto), id);
    }

    public void deleteTopic(String id) {
        this.dataManagerTopic.deleteTopic(id);
    }

    public TopicBo getById(String id) {
        return this.dataManagerTopic.getById(id);
    }

    public TopicDto getByIdDto(String id) {
        return this.topicDtoBoMapper.toDto(this.getById(id));
    }

    public TopicBo getByIdAndName(String id, String name) {
        return this.dataManagerTopic.getByIdAndName(id, name);
    }

    public TopicDto getByIdAndNameDto(String id, String name) {
        return this.topicDtoBoMapper.toDto(this.getByIdAndName(id, name));
    }

    public List<BookBo> getAllBooks() {
        return this.dataManagerBook.getAllBooks();
    }

    public List<BookDto> getAllBookDtos() {
        return this.getAllBooks().stream()
                .map(e -> this.bookDtoBoMapper.toDto(e))
                .collect(Collectors.toList());
    }

    public BookBo getBook(String id) {
        return this.dataManagerBook.getBook(id);
    }

    public BookDto getBookDto(String id) {
        return this.bookDtoBoMapper.toDto(this.getBook(id));
    }

    public void addBook(BookBo bookBo) {
        this.dataManagerBook.addBook(bookBo);
    }

    public void addBookDto(BookDto bookDto) {
        this.addBook(this.bookDtoBoMapper.toBo(bookDto));
    }

    public void updateBook(BookBo bookBo, String id) {
        this.dataManagerBook.updateBook(bookBo, id);
    }

    public void updateBookDto(BookDto bookDto, String id) {
        this.updateBook(this.bookDtoBoMapper.toBo(bookDto), id);
    }

    public void deleteBook(String id) {
        this.dataManagerBook.deleteBook(id);
    }
}
