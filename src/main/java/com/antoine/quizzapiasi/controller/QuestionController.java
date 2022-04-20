package com.antoine.quizzapiasi.controller;

import com.antoine.quizzapiasi.service.question.QuestionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/quizz/")
// on autorise mon client angular
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {

    private final QuestionServiceImpl questionService;

    public QuestionController(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }


}
