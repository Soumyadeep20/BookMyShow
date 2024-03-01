package com.Book_My_Show.BookMyShow.service;

import com.Book_My_Show.BookMyShow.RequestDTOs.AddMovieDTO;
import com.Book_My_Show.BookMyShow.enums.Genre;
import com.Book_My_Show.BookMyShow.enums.Language;
import com.Book_My_Show.BookMyShow.models.Movie;
import com.Book_My_Show.BookMyShow.repository.MovieRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class MovieService {
    @Autowired
    MovieRepository  movieRepository;
    public Movie add(AddMovieDTO movie) {
        Movie newMovie= Movie.builder()
                .movieName(movie.getMovieName())
                .genre(movie.getGenre())
                .movieLanguage((movie.getMovieLanguage()))
                .releaseDate(movie.getReleaseDate())
                .duration(movie.getDuration())
                .rating(movie.getRating())
                .build();
        movieRepository.save(newMovie);
        return newMovie;

    }
}
