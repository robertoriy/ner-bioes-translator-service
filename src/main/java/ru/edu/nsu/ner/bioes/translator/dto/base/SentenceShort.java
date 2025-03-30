package ru.edu.nsu.ner.bioes.translator.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "id",
        "originalFullSentence",
        "translatedFullSentence",
        "status"
})
public record SentenceShort(
        @JsonProperty("id")
        long id,

        @JsonProperty("originalFullSentence")
        String originalFullSentence,

        @JsonProperty("translatedFullSentence")
        String translatedFullSentence,

        @JsonProperty("status")
        String status
) {
}
