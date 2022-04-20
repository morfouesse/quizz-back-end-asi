package com.antoine.quizzapiasi.service.question;

import com.antoine.quizzapiasi.model.Question;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface IQuestionService {

    void addQuestionsInSurvey(@NonNull Set<Question> questions);

}
