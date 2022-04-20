package com.antoine.quizzapiasi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "SURVEYS")
public class Survey {
    @Id
    @NonNull
    //@GeneratedValue
    private int id;
    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    @OneToMany(mappedBy = "survey")
    private Set<Question> questions;

    public Survey() {
    }

    public Survey(int id, @NonNull String title, @NonNull String description) {
        this.id = id;
        this.title = title;
        this.description = description;
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

    // ne fonctionne pas, difficulter à avoir les questions
    @Override
    public String toString() {
        String survey = "Survey{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", question= ";
        for (Question question :
                this.questions) {
            survey += question.toString();
        }
        return survey;
    }
}
