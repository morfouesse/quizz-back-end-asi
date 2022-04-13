package com.antoine.quizzapiasi.service;

import com.antoine.quizzapiasi.model.Survey;
import org.springframework.lang.NonNull;

public interface ISurveyService {
    Iterable<Survey> findAllSurvey();

    Survey findSurveyById(@NonNull int id);

    void addSurvey(@NonNull Survey survey);

    void modifySurvey(@NonNull Survey survey);

    void removeSurvey(@NonNull int id);

}
