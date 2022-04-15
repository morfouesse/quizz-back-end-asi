package com.antoine.quizzapiasi.fixture;

import com.antoine.quizzapiasi.dao.IQuestionDao;
import com.antoine.quizzapiasi.dao.ISurveyDao;
import com.antoine.quizzapiasi.model.Question;
import com.antoine.quizzapiasi.model.Survey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class Fixture {

    private final ISurveyDao iSurveyDao;
    private final IQuestionDao iQuestionDao;


    public Fixture(ISurveyDao iSurveyDao, IQuestionDao iQuestionDao) {
        this.iSurveyDao = iSurveyDao;
        this.iQuestionDao = iQuestionDao;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        iSurveyDao.saveAllAndFlush(this.getSurveys());
        iQuestionDao.saveAllAndFlush(this.getQuestions());
    }

    public static final int SURVEYS = 5;
    public static final int QUESTIONS = 5;

    public List<Survey> getSurveys() {
        List<Survey> surveys = new ArrayList<>();

        for (int i = 1; i <= SURVEYS; i++) {

            Survey survey = new Survey(i, "SurveyTitle" + i, "surveyDescription" + i);
            surveys.add(survey);
        }
        return surveys;
    }

    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        List<Survey> surveys = iSurveyDao.findAll();
        for (int i = 1; i <= QUESTIONS; i++) {
            Question question = new Question(i, "questionTitle" + i, surveys.get(i - 1));

            questions.add(question);

        }
        for (int i = 6; i <= QUESTIONS + 5 ; i++) {
            Question question2 = new Question(i, "questionTitle" + i, surveys.get(i - 6));
            questions.add(question2);
        }

     return  questions;
    }
}
