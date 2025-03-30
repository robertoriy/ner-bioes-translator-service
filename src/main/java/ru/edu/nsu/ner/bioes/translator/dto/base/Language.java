package ru.edu.nsu.ner.bioes.translator.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "name",
        "code"
})
public record Language(
        @JsonProperty("name")
        String name,

        @JsonProperty("code")
        String code
) {
}
