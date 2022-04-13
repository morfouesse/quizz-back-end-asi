package com.antoine.quizzapiasi.model;

import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;

public class Survey {
    @Id
    @NonNull
    private int id;
    @NonNull
    private String title;
    @NonNull
    private String description;


    public Survey(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
