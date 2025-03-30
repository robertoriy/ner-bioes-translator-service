package ru.edu.nsu.ner.bioes.translator.service;

import org.springframework.data.domain.Pageable;
import ru.edu.nsu.ner.bioes.translator.dto.response.SentenceResponse;
import ru.edu.nsu.ner.bioes.translator.dto.response.SentencesResponse;

public interface SentenceService {
    SentencesResponse getSentences(long requestId, Pageable pageable);

    SentenceResponse getSentence(long requestId, long id);
}
