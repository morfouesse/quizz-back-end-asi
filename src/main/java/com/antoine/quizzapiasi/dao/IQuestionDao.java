package com.antoine.quizzapiasi.dao;

import com.antoine.quizzapiasi.model.Question;
import com.antoine.quizzapiasi.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IQuestionDao  extends JpaRepository<Question, Integer> {
    List<Question> findAllBySurveyId(@NonNull int id);
}
