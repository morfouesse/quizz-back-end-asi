package com.antoine.quizzapiasi.fixture;

import com.antoine.quizzapiasi.dao.IAnswerDao;
import com.antoine.quizzapiasi.dao.IQuestionDao;
import com.antoine.quizzapiasi.dao.ISurveyDao;
import com.antoine.quizzapiasi.model.Answer;
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
    private final IAnswerDao iAnswerDao;


    public Fixture(ISurveyDao iSurveyDao, IQuestionDao iQuestionDao, IAnswerDao iAnswerDao) {
        this.iSurveyDao = iSurveyDao;
        this.iQuestionDao = iQuestionDao;
        this.iAnswerDao = iAnswerDao;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        // ne fonctionne plus avec la validation coté back-end
       /* iSurveyDao.saveAllAndFlush(this.getSurveys());
        iQuestionDao.saveAllAndFlush(this.getQuestions());
        iAnswerDao.saveAllAndFlush(this.getAnswers());*/
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

    public List<Answer> getAnswers() {
        List<Answer> answers = new ArrayList<>();
        List<Question> questions = iQuestionDao.findAll();

        Answer answer = new Answer("3", true, questions.get(0));
        Answer answer1 = new Answer("52", false, questions.get(0));
        Answer answer2 = new Answer("jamais", false, questions.get(0));
        Answer answer3 = new Answer("2", false, questions.get(0));

        answers.add(answer);
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);

        Answer answer4 = new Answer("11 min", true, questions.get(1));
        Answer answer5 = new Answer("2 heures", false, questions.get(1));
        Answer answer6 = new Answer("2 jours", false, questions.get(1));
        Answer answer7 = new Answer("il ne faut pas le cuire", false, questions.get(1));

        answers.add(answer4);
        answers.add(answer5);
        answers.add(answer6);
        answers.add(answer7);

        Answer answer8 = new Answer("3 min", true, questions.get(2));
        Answer answer9 = new Answer("une demi heure", false, questions.get(2));
        Answer answer10 = new Answer("jamais", false, questions.get(2));
        Answer answer11 = new Answer("quelques secondes", false, questions.get(2));

        answers.add(answer8);
        answers.add(answer9);
        answers.add(answer10);
        answers.add(answer11);

        Answer answer12 = new Answer("11 min", true, questions.get(3));
        Answer answer13 = new Answer("59 min", false, questions.get(3));
        Answer answer14 = new Answer("12 min", false, questions.get(3));
        Answer answer15 = new Answer("1 min", false, questions.get(3));

        answers.add(answer12);
        answers.add(answer13);
        answers.add(answer14);
        answers.add(answer15);

        return answers;
    }

}
