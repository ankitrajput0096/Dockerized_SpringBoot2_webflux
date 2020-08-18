package com.springboot.webflux.serviceInterface;

import com.springboot.webflux.bo.BookBo;
import com.springboot.webflux.bo.TopicBo;
import com.springboot.webflux.dto.BookDto;
import com.springboot.webflux.dto.TopicDto;

import java.util.List;

public interface BooksAndTopicsSpringIface {

    List<TopicBo> getAllTopics();

    List<TopicDto> getAllTopicsDtos();

    TopicBo getTopic(String id);

    TopicDto getTopicDto(String id);

    void addTopic(TopicBo topicBo);

    void addTopicDto(TopicDto topicDto);

    void updateTopic(TopicBo topicBo, String id);

    void updateTopicDto(TopicDto topicDto, String id);

    void deleteTopic(String id);

    TopicBo getById(String id);

    TopicDto getByIdDto(String id);

    TopicBo getByIdAndName(String id, String name);

    TopicDto getByIdAndNameDto(String id, String name);

    List<BookBo> getAllBooks();

    List<BookDto> getAllBookDtos();

    BookBo getBook(String id);

    BookDto getBookDto(String id);

    void addBook(BookBo bookBo);

    void addBookDto(BookDto bookDto);

    void updateBook(BookBo bookBo, String id);

    void updateBookDto(BookDto bookDto, String id);

    void deleteBook(String id);
}
