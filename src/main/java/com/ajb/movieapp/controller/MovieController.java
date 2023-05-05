package com.ajb.movieapp.controller;

import com.ajb.movieapp.model.Movie;
import com.ajb.movieapp.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import com.ajb.movieapp.service.MovieService;

@Slf4j
@RestController
public class MovieController {

    //Inject MovieService dependency via constructor injection
    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies/{imdbId}")
    public Mono<Movie>getMovie(@PathVariable String imdbId) {
        String apiKey = "d3b5280e";

        return  movieService.getMovie(apiKey, imdbId);

    }

    @PostMapping("/login")
    public Mono<User>login(@RequestBody User loginUser){

        return movieService.findUserByUsername(loginUser.getUsername())
                .filter(user -> user.getPassword().equals(loginUser.getPassword()));
    }
    @PostMapping("/register")
    public Mono<User>register(@RequestBody User newUser) {

        return movieService.saveUser(newUser);
    }
}
