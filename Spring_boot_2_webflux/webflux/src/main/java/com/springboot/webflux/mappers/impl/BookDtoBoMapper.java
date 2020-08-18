package com.springboot.webflux.mappers.impl;

import com.springboot.webflux.bo.BookBo;
import com.springboot.webflux.dto.BookDto;
import com.springboot.webflux.mappers.DtoBoMapperIface;
import org.springframework.stereotype.Component;

@Component
public class BookDtoBoMapper implements DtoBoMapperIface<BookBo, BookDto> {

    @Override
    public BookBo toBo(BookDto bookDto) {
        return BookBo.builder()
                .id(bookDto.getId())
                .name(bookDto.getName())
                .build();
    }

    @Override
    public BookDto toDto(BookBo bookBo) {
        return BookDto.builder()
                .id(bookBo.getId())
                .name(bookBo.getName())
                .build();
    }
}
