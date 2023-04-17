package service;

import com.ajb.movieapp.Movie;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MovieService {
    private static final String OMDB_API_BASE_URL="http://www.omdbapi.com/";

    private final WebClient webClient;

    public MovieService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(OMDB_API_BASE_URL).build();
    }

    public Mono<Movie> getMovie(String apiKey, String imdbId) {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("apikey", apiKey)
                        .queryParam("i", imdbId)
                        .build())
                .retrieve()
                .bodyToMono(Movie.class);

    }

}
