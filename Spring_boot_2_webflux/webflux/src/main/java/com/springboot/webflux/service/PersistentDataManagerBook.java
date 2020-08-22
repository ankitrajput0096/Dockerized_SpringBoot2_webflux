package com.springboot.webflux.service;

import com.springboot.webflux.bo.BookBo;
import com.springboot.webflux.entity.Book;
import com.springboot.webflux.mappers.impl.BookBoEntityMapper;
import com.springboot.webflux.repository.BookRepository;
import com.springboot.webflux.serviceInterface.DataManagerBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j     // NOTE : way to use logger using lambok library
@Service
public class PersistentDataManagerBook
        implements DataManagerBook {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookBoEntityMapper bookBoEntityMapper;

    public List<BookBo> getAllBooks() {
        log.info("Returning all the books from db");
        return this.bookRepository.findAll().stream()
                .map(e -> this.bookBoEntityMapper.toBo(e))
                .collect(Collectors.toList());
    }

    public BookBo getBook(String id) {
        log.info("return the book with id : {}", id);
        Optional<Book> book = this.bookRepository.findById(id);
        if(book.isPresent()) {
            log.info("the book with id found : {}", id);
            return this.bookBoEntityMapper.toBo(book.get());
        }
        else {
            log.info("the book with id {} not found", id);
            return null;
        }
    }

    public void addBook(BookBo bookBo) {
        log.info("Adding new book in the db with details : {}",
                bookBo.toString());
        this.bookRepository.save(
                this.bookBoEntityMapper.toEntity(bookBo));
    }

    public void updateBook(BookBo bookBo, String id) {
        log.info("Updating the existing book with id : {}", id);
        this.bookRepository.deleteById(id);
        this.bookRepository.save(
                this.bookBoEntityMapper.toEntity(bookBo));
    }

    public void deleteBook(String id) {
        log.info("Deleting the existing book with id : {}", id);
        this.bookRepository.deleteById(id);
    }
}
