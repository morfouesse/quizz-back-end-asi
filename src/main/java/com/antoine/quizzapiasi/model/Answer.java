package com.antoine.quizzapiasi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="ANSWERS")
public class Answer {
    @Id
    @NonNull
    @GeneratedValue
    private int id;

    @NonNull
    private String name;

    @NonNull
    @ManyToOne
    @JsonBackReference
    private Question question;

    public Answer(){}

    public Answer(@NonNull String name, @NonNull Question question) {
        this.name = name;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    @JsonBackReference
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(@NonNull Question question) {
        this.question = question;
    }
}
