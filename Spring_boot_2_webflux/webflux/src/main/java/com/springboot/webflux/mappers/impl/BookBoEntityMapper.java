package com.springboot.webflux.mappers.impl;

import com.springboot.webflux.bo.BookBo;
import com.springboot.webflux.entity.Book;
import com.springboot.webflux.mappers.BoEntityMapperIface;
import org.springframework.stereotype.Component;

@Component
public class BookBoEntityMapper implements BoEntityMapperIface<BookBo, Book> {

    @Override
    public BookBo toBo(Book book) {
        return BookBo.builder()
                .id(book.getId())
                .name(book.getName())
                .build();
    }

    @Override
    public Book toEntity(BookBo bookBo) {
        return Book.builder()
                .id(bookBo.getId())
                .name(bookBo.getName())
                .build();
    }
}
