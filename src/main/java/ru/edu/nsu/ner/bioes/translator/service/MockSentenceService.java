package ru.edu.nsu.ner.bioes.translator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.edu.nsu.ner.bioes.translator.dao.MockSentenceDao;
import ru.edu.nsu.ner.bioes.translator.dto.response.SentenceResponse;
import ru.edu.nsu.ner.bioes.translator.dto.response.SentencesResponse;

@Service
//@Profile("mock")
@RequiredArgsConstructor
public class MockSentenceService implements SentenceService {
    @Override
    public SentencesResponse getSentences(long requestId, Pageable pageable) {
        return MockSentenceDao.getPageOfSentences(pageable);
    }

    @Override
    public SentenceResponse getSentence(long requestId, long id) {
        return MockSentenceDao.getSentenceResponse(id);
    }
}
