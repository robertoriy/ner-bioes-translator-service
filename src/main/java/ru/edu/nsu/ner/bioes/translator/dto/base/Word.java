package ru.edu.nsu.ner.bioes.translator.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "word",
        "tag",
        "entityType"
})
public record Word(
        @JsonProperty("word")
        String word,

        @JsonProperty("tag")
        Tag tag,

        @JsonProperty("entityType")
        EntityType entityType
) {
}
