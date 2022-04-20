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

    public List<Survey> getSurveys() {
        List<Survey> surveys = new ArrayList<>();

        Survey survey = new Survey("Tout savoir sur la nourriture", "Un questionnaire sur la nourriture");
        Survey survey1 = new Survey("Tout savoir sur la nourriture, deuxième édition", "Encore Un questionnaire sur la nourriture !");
        Survey survey2 = new Survey("Tout savoir sur la nourriture, troisième édition", "Encore Un questionnaire sur la nourriture !");
        Survey survey3 = new Survey("Tout savoir sur la nourriture, final édition", "Encore Un questionnaire sur la nourriture !");

        surveys.add(survey);
        surveys.add(survey1);
        surveys.add(survey2);
        surveys.add(survey3);

        return surveys;
    }

    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        List<Survey> surveys = iSurveyDao.findAll();

        Question question = new Question("Combien de fruits et légumes faut-il manger par jour ?", surveys.get(0));
        Question question1 = new Question("Combien de temps faut-il cuire le riz ?", surveys.get(0));
        Question question2 = new Question("Combien de temps faut-il cuire les pâtes ?", surveys.get(0));
        Question question3 = new Question("Combien de temps faut-il cuire les oignons ?", surveys.get(0));

        questions.add(question);
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);

        Question question4 = new Question("Combien de fruits et légumes faut-il manger par jour ?", surveys.get(1));
        Question question5 = new Question("Combien de temps faut-il cuire le riz ?", surveys.get(1));
        Question question6 = new Question("Combien de temps faut-il cuire les pâtes ?", surveys.get(1));
        Question question7 = new Question("Combien de temps faut-il cuire les oignons ?", surveys.get(1));

        questions.add(question4);
        questions.add(question5);
        questions.add(question6);
        questions.add(question7);

        Question question8 = new Question("Combien de fruits et légumes faut-il manger par jour ?", surveys.get(2));
        Question question9 = new Question("Combien de temps faut-il cuire le riz ?", surveys.get(2));
        Question question10 = new Question("Combien de temps faut-il cuire les pâtes ?", surveys.get(2));
        Question question11 = new Question("Combien de temps faut-il cuire les oignons ?", surveys.get(2));

        questions.add(question8);
        questions.add(question9);
        questions.add(question10);
        questions.add(question11);

        Question question12 = new Question("Combien de fruits et légumes faut-il manger par jour ?", surveys.get(3));
        Question question13 = new Question("Combien de temps faut-il cuire le riz ?", surveys.get(3));
        Question question14 = new Question("Combien de temps faut-il cuire les pâtes ?", surveys.get(3));
        Question question15 = new Question("Combien de temps faut-il cuire les oignons ?", surveys.get(3));

        questions.add(question12);
        questions.add(question13);
        questions.add(question14);
        questions.add(question15);

        return questions;
    }
}
