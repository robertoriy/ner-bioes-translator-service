package ru.edu.nsu.ner.bioes.translator.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "id",
        "name"
})
public record RequestResponse(
        @JsonProperty("id")
        long id,

        @JsonProperty("name")
        String name
) {
}
