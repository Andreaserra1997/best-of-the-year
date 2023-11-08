package com.experis.course.bestoftheyear.controller;

import com.experis.course.bestoftheyear.model.Movie;
import com.experis.course.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String index(Model model) {
        String name = "Andrea";
        model.addAttribute("myName", name);
        return "index";
    }

    @GetMapping("movies")
    public String bestMovies(Model model, @RequestParam(name = "name", required = false) String nameParam) {
        List<Movie> filteredMovies = nameParam != null ? getFilteredMovies(nameParam) : getBestMovies();
        model.addAttribute("bestMovies", filteredMovies);
        return "movies";
    }

    @GetMapping("/movies/{id}")
    public String movieDetail(@PathVariable("id") String id, Model model) {
        Movie movie = getMovieByCode(id);
        model.addAttribute("movie", movie);
        return "movie-detail";
    }

    @GetMapping("songs")
    public String bestSongs(Model model, @RequestParam(name = "name", required = false) String nameParam) {
        List<Song> filteredSongs = nameParam != null ? getFilteredSongs(nameParam) : getBestSongs();
        model.addAttribute("bestSongs", filteredSongs);
        return "songs";
    }

    @GetMapping("/songs/{id}")
    public String songDetail(@PathVariable("id") String id, Model model) {
        Song song = getSongByCode(id);
        model.addAttribute("song", song);
        return "song-detail";
    }

    //METODI
    private List<Movie> getBestMovies() {
        Movie[] moviesArray = {new Movie("1","Titanic"), new Movie("2", "Avatar"), new Movie("3", "Avengers")};
        return Arrays.asList(moviesArray);
    }

    private List<Movie> getFilteredMovies(String search) {
        return getBestMovies().stream().filter(movie -> movie.getTitolo().contains(search)).collect(Collectors.toList());
    }

    private Movie getMovieByCode(String id) {
        for (Movie movie : getBestMovies()) {
            if (movie.getId().equals(id)) {
                return movie;
            }
        }
        return null;
    }

    private List<Song> getBestSongs() {
        Song[] songsArray = {new Song("1", "Billie Jean"), new Song("2", "Lose Yourself"), new Song("3", "The Real Slim Shady")};
        return Arrays.asList(songsArray);
    }

    private List<Song> getFilteredSongs(String search) {
        return getBestSongs().stream().filter(song -> song.getTitolo().contains(search)).collect(Collectors.toList());
    }

    private Song getSongByCode(String id) {
        for (Song song : getBestSongs()) {
            if (song.getId().equals(id)) {
                return song;
            }
        }
        return null;
    }

}
