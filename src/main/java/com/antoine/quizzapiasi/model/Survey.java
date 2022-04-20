package com.antoine.quizzapiasi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "SURVEYS")
public class Survey {

    @Id
    @NonNull
    @GeneratedValue
    private int id;
    @NonNull
    private String title;
    @NonNull
    private String description;

    @NonNull
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

    public void setId(int id) {
        this.id = id;
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
