package com.Book_My_Show.BookMyShow.RequestDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddShowSeatDTO {
    private int seatId;
    private int showId;
}
