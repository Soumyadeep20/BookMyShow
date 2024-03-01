package com.Book_My_Show.BookMyShow.RequestDTOs;

import com.Book_My_Show.BookMyShow.enums.Genre;
import com.Book_My_Show.BookMyShow.enums.Language;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMovieDTO {
    private String movieName;
    private Genre genre;
    private Language movieLanguage;
    private LocalDate releaseDate;
    private int duration;
    private int rating;
}
