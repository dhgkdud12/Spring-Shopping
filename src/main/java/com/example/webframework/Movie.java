package com.example.webframework;

import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Movie {
    private  int id;
    private  String title;
    private String genre;

    public Movie(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
