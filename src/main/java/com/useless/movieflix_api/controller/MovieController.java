package com.useless.movieflix_api.controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.useless.movieflix_api.exceptions.NotFoundException;
import com.useless.movieflix_api.model.MovieModel;
import com.useless.movieflix_api.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieRepository movieRepository;

    @GetMapping
    public ResponseEntity<List<MovieModel>> getAllMovies() {
        List<MovieModel> movies = movieRepository.findAll(PageRequest.of(0, 18)).getContent();

        if (movies == null || movies.isEmpty()) {
            throw new NotFoundException("No movies");
        }

        return ResponseEntity.ok(movies);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getMoviesBySimilarName(@RequestParam String movieName) {
            List<MovieModel> movies = movieRepository.findByMovieNameContainingIgnoreCase(movieName);

            if (movies.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(movies);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMovie(@RequestBody MovieModel movie) {
        MovieModel saved_movie = movieRepository.save(movie);

        return ResponseEntity.status(201).body(saved_movie);
    }
}
