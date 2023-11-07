package com.experis.course.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String index(Model model) {
        String name = "Andrea";
        model.addAttribute("myName", name);
        return "index";
    }

    private List<String> getBestMovies() {
        List<String> movies = new ArrayList<>();
        movies.add("Titanic");
        movies.add("Avatar");
        movies.add("Avengers");
        return movies;
    }

    private List<String> getBestSongs() {
        List<String> songs = new ArrayList<>();
        songs.add("Billie Jean");
        songs.add("Lose Yourself");
        songs.add("The Real Slim Shady");
        return songs;
    }

    @GetMapping("movies")
    public String bestMovies(Model model) {
        List<String> movies = getBestMovies();
        String concatenatedMovies = String.join(", ", movies);
        model.addAttribute("bestMovies", concatenatedMovies);
        return "movies";
    }

    @GetMapping("songs")
    public String bestSongs(Model model) {
        List<String> songs = getBestSongs();
        String concatenatedSongs = String.join(", ", songs);
        model.addAttribute("bestSongs", concatenatedSongs);
        return "songs";
    }

}
