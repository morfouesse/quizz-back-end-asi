package com.antoine.quizzapiasi.controller;

import com.antoine.quizzapiasi.apiElements.SurveyEndpoint;
import com.antoine.quizzapiasi.model.Survey;
import com.antoine.quizzapiasi.service.survey.SurveyServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> getSurveys() throws ResponseStatusException{
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
    public  ResponseEntity<?> getSurveyById(@PathVariable("id") int id) throws ResponseStatusException {
        try{

            Survey survey = surveyService.findSurveyById(id);
            // si tout se passe bien alors on envoie la requete
            return ResponseEntity.ok(survey);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);
        }
    }


    @PostMapping(path = SurveyEndpoint.CREATE_SURVEY, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addSurveyWithQuestionsWithAnswers(@Valid @RequestBody Survey surveyClient) throws ResponseStatusException {

        try {
            surveyService.addSurvey(surveyClient);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);
        }

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }



}
