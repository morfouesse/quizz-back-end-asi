package com.antoine.quizzapiasi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "SURVEYS")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @NotBlank(message = "Le titre n'est pas valide")
    @Size(min = 4)
    private String title;
    @NonNull
    @NotBlank(message = "Le titre du questionnaire n'est pas valide")
    @Size(min = 4)
    private String description;

    @NonNull
    @Valid
    @Size(message = "Il doit y avoir entre 2 et 10 questions", min=2, max=10)
    // cascade.all => all entity operations (PERSIST, REMOVE, REFRESH, MERGE, DETACH)
    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL)
    private Set<Question> questions;

    public Survey() {
    }

    public Survey(@NonNull String title, @NonNull String description) {
        this.title = title;
        this.description = description;
        this.questions = new HashSet<>();
    }

    public Survey(@NonNull String title, @NonNull String description, @NonNull Set<Question> questions) {
        this.title = title;
        this.description = description;
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    @NonNull
    @JsonManagedReference
    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(@NonNull Set<Question> question) {
        this.questions = question;
    }

    @Override
    public String toString() {
        StringBuilder survey = new StringBuilder("Survey{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", question= ");
        for (Question question :
                this.getQuestions()) {
            survey.append(question.toString());
        }
        return survey.toString();
    }
}
