package com.Book_My_Show.BookMyShow.RequestDTOs;

import com.Book_My_Show.BookMyShow.models.Movie;
import com.Book_My_Show.BookMyShow.models.Theater;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddShowDTO {
    private int movie;
    private int theater;
}
