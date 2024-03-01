package com.Book_My_Show.BookMyShow.controlers;

import com.Book_My_Show.BookMyShow.RequestDTOs.AddMovieDTO;
import com.Book_My_Show.BookMyShow.models.Movie;
import com.Book_My_Show.BookMyShow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")

public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<Movie> add(@RequestBody AddMovieDTO movie)
    {
        Movie newMovie=movieService.add(movie);
        return  new ResponseEntity<>(newMovie, HttpStatus.OK);
    }
}
