package com.useless.movieflix_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.useless.movieflix_api.models.MovieModel;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, Long> {}
