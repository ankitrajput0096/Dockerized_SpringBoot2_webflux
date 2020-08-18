package com.springboot.webflux.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopicBo {  // Here, Bo => Business Object, which is used at business layer(in service classes).

    @NotNull
    @JsonProperty(value = "topic_id")
    private String id;

    @JsonProperty(value = "topic_name")
    private String name;

    @JsonProperty(value = "topic_desc")
    private String description;
}
