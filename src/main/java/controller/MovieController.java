package controller;

import model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import service.MovieService;

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
}
