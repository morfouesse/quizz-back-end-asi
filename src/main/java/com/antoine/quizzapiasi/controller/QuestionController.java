package com.antoine.quizzapiasi.controller;

import com.antoine.quizzapiasi.apiElements.QuestionEndpoint;
import com.antoine.quizzapiasi.model.Question;
import com.antoine.quizzapiasi.service.question.QuestionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

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

    @PostMapping(path = QuestionEndpoint.CREATE_QUESTIONS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addQuestions(@RequestBody Set<Question> questions) {
        try {
            questionService.addQuestionsInSurvey(questions);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);
        }

    }

}
