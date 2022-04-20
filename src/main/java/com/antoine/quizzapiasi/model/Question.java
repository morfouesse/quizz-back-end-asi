package com.antoine.quizzapiasi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "QUESTIONS")
public class Question {
    @Id
    @NonNull
    @GeneratedValue
    private int id;

    @NonNull
    private String title;

    @ManyToOne
    @NonNull
    private Survey survey;

    @NonNull
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<Answer> answers;

    public Question() {

    }
    public Question(@NonNull String title, @NonNull Survey survey) {
        this.title = title;
        this.survey = survey;
        this.answers = new HashSet<>();
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
    @JsonManagedReference
    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(@NonNull Set<Answer> answers) {
        this.answers = answers;
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
