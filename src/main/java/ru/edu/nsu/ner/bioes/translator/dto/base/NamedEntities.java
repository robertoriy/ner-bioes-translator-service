package ru.edu.nsu.ner.bioes.translator.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({
        "recognizedEntities",
        "unrecognizedEntities"
})
public record NamedEntities(
        @JsonProperty("recognizedEntities")
        List<RecognizedEntity> recognizedEntities,

        @JsonProperty("unrecognizedEntities")
        List<UnrecognizedEntities> unrecognizedEntities
) {
}
