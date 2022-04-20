package com.antoine.quizzapiasi.service.question;

import com.antoine.quizzapiasi.dao.IQuestionDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class QuestionServiceImpl implements IQuestionService {

    private final IQuestionDao iQuestionDao;

    public QuestionServiceImpl(IQuestionDao iQuestionDao) {
        this.iQuestionDao = iQuestionDao;
    }

}
