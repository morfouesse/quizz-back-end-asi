package com.antoine.quizzapiasi.service.question;

import com.antoine.quizzapiasi.dao.IQuestionDao;
import com.antoine.quizzapiasi.model.Question;
import com.antoine.quizzapiasi.model.Survey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class QuestionServiceImpl implements IQuestionService {

    private final IQuestionDao iQuestionDao;

    public QuestionServiceImpl(IQuestionDao iQuestionDao) {
        this.iQuestionDao = iQuestionDao;
    }

    @Override
    public void addQuestionsInSurvey(@NonNull Set<Question> questions) {
        iQuestionDao.saveAll(questions);
    }
}
