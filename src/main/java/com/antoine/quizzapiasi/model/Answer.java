package com.antoine.quizzapiasi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "ANSWERS")
public class Answer {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @NotBlank(message = "Le nom de la réponse n'est pas valide")
    @Size(message = "une réponse doit faire entre 1 et 30 caractères", min = 1, max = 30)
    private String name;

    @NonNull
    //TODO: crée une validation custom -> une seul reponse dois etre true dans une liste de réponses
    private boolean goodAnswer;

    @NonNull
    @ManyToOne
    private Question question;

    public Answer() {
    }

    public Answer(@NonNull String name, boolean goodAnswer, @NonNull Question question) {
        this.name = name;
        this.goodAnswer = goodAnswer;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public boolean isGoodAnswer() {
        return goodAnswer;
    }

    public void setGoodAnswer(boolean goodAnswer) {
        this.goodAnswer = goodAnswer;
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
