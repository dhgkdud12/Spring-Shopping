package com.example.webframework;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class APIController {
    List<Movie> movies = new ArrayList();

    public  APIController() {
        movies.add(new Movie(1, "싱2게더"));
        movies.add(new Movie(3, "웨스트사이드스토리"));
        movies.add(new Movie(10, "특송"));
        movies.add(new Movie(20, "스파이더맨"));
    }


    @RequestMapping("/api")
    public String api() {
        Movie m = new Movie(1, "싱2게더");
        return m.toString();
    }

    @RequestMapping("/api2")
    public Movie api2() {
        Movie m = new Movie(1, "싱2게더");
        return m;
    }

    @RequestMapping("/api3")
    public Map api3() {

        Map<String, String > map= new HashMap();
        map.put("title", "영화 검색 사이트");
        map.put("addres", "경기도 ~~~~~");
        return  map;
    }

    @RequestMapping("/getmovies")
    public Map getmovie() {
        Map<String, Object > map= new HashMap();
        map.put("title", "영화 검색 사이트");
        map.put("addres", "경기도 ~~~~~");
        map.put("movies", movies);
        return  map;
    }
}
