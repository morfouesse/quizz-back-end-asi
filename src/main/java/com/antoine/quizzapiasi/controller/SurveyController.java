package com.antoine.quizzapiasi.controller;

import com.antoine.quizzapiasi.apiElements.SurveyEndpoint;
import com.antoine.quizzapiasi.model.Survey;
import com.antoine.quizzapiasi.service.survey.SurveyServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/quizz/")
// on autorise mon client angular
@CrossOrigin(origins = "http://localhost:4200")
public class SurveyController {

    private final SurveyServiceImpl surveyService;


    public SurveyController(SurveyServiceImpl surveyService) {
        this.surveyService = surveyService;
    }


    @GetMapping(path = SurveyEndpoint.SURVEYS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSurveys() {
        try{

            List<Survey> surveyList = surveyService.findAllSurveys();

            //surveyList.forEach((survey -> log.info(survey.toString())));
            // si tout se passe bien alors on envoie la requete
            return ResponseEntity.ok(surveyList);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);
        }
    }

    @GetMapping(path = SurveyEndpoint.SURVEY, produces =  MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<?> getSurveyById(@PathVariable("id") int id){
        try{

            Survey survey = surveyService.findSurveyById(id);
            // si tout se passe bien alors on envoie la requete
            return ResponseEntity.ok(survey);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);
        }
    }


    @PostMapping(path = SurveyEndpoint.CREATE_SURVEY, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addSurveyWithQuestionsWithAnswers(@RequestBody Survey surveyClient) {

        try {

            surveyService.addSurvey(surveyClient);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);
        }

    }




}
