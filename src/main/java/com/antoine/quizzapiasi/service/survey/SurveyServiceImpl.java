package com.antoine.quizzapiasi.service.survey;

import com.antoine.quizzapiasi.dao.ISurveyDao;
import com.antoine.quizzapiasi.model.Question;
import com.antoine.quizzapiasi.model.Survey;
import com.antoine.quizzapiasi.service.survey.ISurveyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SurveyServiceImpl implements ISurveyService {

    private final ISurveyDao isurveyDao;

    public SurveyServiceImpl(ISurveyDao isurveyDao) {
        this.isurveyDao = isurveyDao;
    }

    @Override
    public List<Survey> findAllSurveys() {
        return isurveyDao.findAll();
    }

    @Override
    public Survey findSurveyById(@NonNull int id) {
        Optional<Survey> survey= isurveyDao.findById(id);
        return survey.orElseThrow();
    }

    @Override
    public void addSurvey(@NonNull Survey survey) {
        isurveyDao.save(survey);
    }


    @Override
    public void modifySurvey(@NonNull Survey survey) {
        isurveyDao.saveAndFlush(survey);
    }

    @Override
    public void removeSurvey(@NonNull int id) {
        isurveyDao.deleteById(id);
    }

}
