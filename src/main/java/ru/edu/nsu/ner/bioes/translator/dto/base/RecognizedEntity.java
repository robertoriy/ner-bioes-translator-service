package ru.edu.nsu.ner.bioes.translator.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "originalEntity",
        "translatedEntity",
        "entityType"
})
public record RecognizedEntity(
        @JsonProperty("originalEntity")
        String originalEntity,

        @JsonProperty("translatedEntity")
        String translatedEntity,

        @JsonProperty("entityType")
        EntityType entityType
) {
}
