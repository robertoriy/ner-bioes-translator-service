package ru.edu.nsu.ner.bioes.translator.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "originalEntity",
        "originalEntityType",
        "possibleEntityTranslation"
})
public record UnrecognizedEntities(
        @JsonProperty("originalEntity")
        String originalEntity,

        @JsonProperty("originalEntityType")
        EntityType originalEntityType,

        @JsonProperty("possibleEntityTranslation")
        String possibleEntityTranslation
) {
}
