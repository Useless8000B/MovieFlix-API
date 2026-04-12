package com.useless.movieflix_api.controllers;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.useless.movieflix_api.models.MovieModel;
import com.useless.movieflix_api.repositories.MovieRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieRepository movieRepository;

    @GetMapping
    public ResponseEntity<List<MovieModel>> getAllMovies() {
        try {
            List<MovieModel> movies = movieRepository.findAll(PageRequest.of(0, 18)).getContent();
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieModel>> getMoviesBySimilarName(@RequestParam String movieName) {
        List<MovieModel> movies = movieRepository.findByMovieNameContainingIgnoreCase(movieName);

        if (movies.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(movies);
    }

    @PostMapping("/add")
    public ResponseEntity<MovieModel> addMovie(@RequestBody MovieModel movie) {
        MovieModel saved_movie = movieRepository.save(movie);
        return ResponseEntity.status(201).body(saved_movie);
    }
}
