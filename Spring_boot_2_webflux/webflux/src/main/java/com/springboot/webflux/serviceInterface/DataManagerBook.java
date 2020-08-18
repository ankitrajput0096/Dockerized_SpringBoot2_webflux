package com.springboot.webflux.serviceInterface;

import com.springboot.webflux.bo.BookBo;
import java.util.List;

public interface DataManagerBook {

    List<BookBo> getAllBooks();

    BookBo getBook(String id);

    void addBook(BookBo bookBo);

    void updateBook(BookBo bookBo, String id);

    void deleteBook(String id);
}
