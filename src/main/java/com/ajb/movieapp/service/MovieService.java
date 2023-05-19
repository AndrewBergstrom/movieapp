package com.ajb.movieapp.service;

import com.ajb.movieapp.model.Movie;
import com.ajb.movieapp.model.User;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MovieService {
    private static final String OMDB_API_BASE_URL="http://www.omdbapi.com/";

    private final WebClient webClient;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public MovieService(WebClient.Builder webClientBuilder, ReactiveMongoTemplate reactiveMongoTemplate) {
        this.webClient = webClientBuilder.baseUrl(OMDB_API_BASE_URL).build();
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    public Mono<User>saveUser(User user){
        return reactiveMongoTemplate.insert(user);
    }

    public Mono<User>findUserByUsername(String username){
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));

        return reactiveMongoTemplate.findOne(query, User.class);
    }

    public Mono<Movie> getMovie(String apiKey, String imdbId) {

//       var response =
        return
        webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("apikey", apiKey)
                        .queryParam("i", imdbId)
                        .build())

                .retrieve()
                .bodyToMono(Movie.class);

    }
}
