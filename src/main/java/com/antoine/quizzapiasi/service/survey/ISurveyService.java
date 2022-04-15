package com.antoine.quizzapiasi.service.survey;

import com.antoine.quizzapiasi.model.Question;
import com.antoine.quizzapiasi.model.Survey;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// transactional : intérer -> si on trouve une erreur, on save pas en BDD, pas besoin de methode flush
@Transactional
public interface ISurveyService {
    @Transactional(readOnly = true)
    List<Survey> findAllSurveys();

    @Transactional(readOnly = true)
    Survey findSurveyById(@NonNull int id);

    void addSurvey(@NonNull Survey survey);


    void modifySurvey(@NonNull Survey survey);

    void removeSurvey(@NonNull int id);

}
