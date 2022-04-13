package com.antoine.quizzapiasi.service;
import com.antoine.quizzapiasi.model.Survey;
import com.antoine.quizzapiasi.dao.ISurveyDao;



public class SurveyServiceImpl implements ISurveyService {

    private final ISurveyDao isurveyDao;

    public SurveyServiceImpl(ISurveyDao isurveyDao) {
        this.isurveyDao = isurveyDao;
    }

    @Override
    public Iterable<Survey> findAllSurvey() {
        return isurveyDao.findAll();
    }

    @Override
    public Survey findSurveyById(int id) {
        return null;
    }

    @Override
    public void addSurvey(Survey survey) {

    }

    @Override
    public void modifySurvey(Survey survey) {

    }

    @Override
    public void removeSurvey(int id) {

    }
}
