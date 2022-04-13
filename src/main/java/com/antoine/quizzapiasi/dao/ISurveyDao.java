package com.antoine.quizzapiasi.dao;


import com.antoine.quizzapiasi.model.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISurveyDao extends CrudRepository<Survey, Integer> {
}
