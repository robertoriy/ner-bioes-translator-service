package ru.edu.nsu.ner.bioes.translator.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({
        "fullSentence",
        "words",
        "tags"
})
public record Sentence(
        @JsonProperty("fullSentence")
        String fullSentence,

        @JsonProperty("words")
        List<Word> words,

        @JsonProperty("tags")
        List<EntityType> tags
) {
}
