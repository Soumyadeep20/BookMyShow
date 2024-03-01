package com.Book_My_Show.BookMyShow.models;

import com.Book_My_Show.BookMyShow.enums.Genre;
import com.Book_My_Show.BookMyShow.enums.Language;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer movieId;
    @Column(unique = true,nullable = false)
    private String movieName;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Enumerated(value = EnumType.STRING)
    private Language movieLanguage;

    private LocalDate releaseDate;

    private int duration;
    private int rating;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    List<Show> showList=new ArrayList<>();
}
