package com.springboot.webflux.mappers.impl;

import com.springboot.webflux.bo.TopicBo;
import com.springboot.webflux.entity.Topic;
import com.springboot.webflux.mappers.BoEntityMapperIface;
import org.springframework.stereotype.Component;

@Component
public class TopicBoEntityMapper implements BoEntityMapperIface<TopicBo, Topic> {

    @Override
    public TopicBo toBo(Topic topic) {
        return TopicBo.builder()
                .id(topic.getId())
                .name(topic.getName())
                .description(topic.getDescription())
                .build();
    }

    @Override
    public Topic toEntity(TopicBo topicBo) {
        return new Topic(topicBo.getId(), topicBo.getName(), topicBo.getDescription());
    }
}
