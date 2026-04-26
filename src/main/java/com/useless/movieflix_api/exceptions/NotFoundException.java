package com.useless.movieflix_api.exceptions;

public class NotFoundException extends RuntimeException {
  NotFoundException(String movieName) {
    super(movieName + "not found!");
  }
}

