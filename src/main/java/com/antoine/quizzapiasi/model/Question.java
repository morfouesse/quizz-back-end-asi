package com.antoine.quizzapiasi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity(name = "QUESTIONS")
public class Question {
    @Id
    @NonNull
    private int id;

    @NonNull
    private String title;

    @ManyToOne
    @JsonBackReference
    @NonNull
    private Survey survey;


    public Question() {

    }

    public Question(int id, @NonNull String title) {
        this.id = id;
        this.title = title;
    }

    public Question(@NonNull int id, @NonNull String title, @NonNull Survey survey) {
        super();
        this.id = id;
        this.title = title;
        this.survey = survey;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public void setSurvey(@NonNull Survey survey) {
        this.survey = survey;
    }

    @NonNull
    @JsonBackReference
    public Survey getSurvey() {
        return survey;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", survey=" + survey +
                '}';
    }

}
