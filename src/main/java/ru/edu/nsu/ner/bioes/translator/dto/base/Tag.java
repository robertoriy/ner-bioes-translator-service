package ru.edu.nsu.ner.bioes.translator.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "prefix",
        "separator"
})
public record Tag(
        @JsonProperty("prefix")
        String prefix,

        @JsonProperty("separator")
        String separator
) {
}
