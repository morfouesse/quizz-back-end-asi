package com.antoine.quizzapiasi.dao;

import com.antoine.quizzapiasi.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswerDao extends JpaRepository<Answer, Integer> {
}
