package com.antoine.quizzapiasi.service.question;

import com.antoine.quizzapiasi.dao.IQuestionDao;
import com.antoine.quizzapiasi.dao.ISurveyDao;
import com.antoine.quizzapiasi.model.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class QuestionServiceImpl implements IQuestionService {

    private final IQuestionDao iQuestionDao;
    private final ISurveyDao iSurveyDao;

    public QuestionServiceImpl(IQuestionDao iQuestionDao, ISurveyDao iSurveyDao) {
        this.iQuestionDao = iQuestionDao;
        this.iSurveyDao = iSurveyDao;
    }

    @Override
    public void addQuestionsInSurvey(@NonNull Iterable<Question> questions) {
        iQuestionDao.saveAll(questions);
    }
}
