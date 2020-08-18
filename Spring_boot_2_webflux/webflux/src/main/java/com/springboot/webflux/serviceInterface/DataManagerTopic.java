package com.springboot.webflux.serviceInterface;

import com.springboot.webflux.bo.TopicBo;
import java.util.List;

public interface DataManagerTopic {

	List<TopicBo> getAllTopics();

    TopicBo getTopic(String id);

    void addTopic(TopicBo topicBo);

    void updateTopic(TopicBo topicBo, String id);

    void deleteTopic(String id);

	TopicBo getById(String id);

	TopicBo getByIdAndName(String id, String name);

    void saveTopic(TopicBo topicBo);
}
