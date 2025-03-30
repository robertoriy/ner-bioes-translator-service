package ru.edu.nsu.ner.bioes.translator.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "type",
        "color"
})
public record EntityType(
        @JsonProperty("type")
        String type,

        @JsonProperty("color")
        String color
) {
}
