package com.springboot.webflux.mappers.impl;

import com.springboot.webflux.bo.TopicBo;
import com.springboot.webflux.dto.TopicDto;
import com.springboot.webflux.mappers.DtoBoMapperIface;
import org.springframework.stereotype.Component;

@Component
public class TopicDtoBoMapper
        implements DtoBoMapperIface<TopicBo, TopicDto> {

    @Override
    public TopicBo toBo(TopicDto topicDto) {
        return TopicBo.builder()
                .id(topicDto.getId())
                .name(topicDto.getName())
                .description(topicDto.getDescription())
                .build();
    }

    @Override
    public TopicDto toDto(TopicBo topicBo) {
        return TopicDto.builder()
                .id(topicBo.getId())
                .name(topicBo.getName())
                .description(topicBo.getDescription())
                .build();
    }
}
