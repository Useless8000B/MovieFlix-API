package com.useless.movieflix_api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.useless.movieflix_api.models.MovieModel;
import com.useless.movieflix_api.repositories.MovieRepository;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieRepository movieRepository;

    @GetMapping
    public ResponseEntity<List<MovieModel>> getAllMovies() {
        List<MovieModel> movies = movieRepository.findAll();
        return ResponseEntity.ok(movies);
    }
}
