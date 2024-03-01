package com.Book_My_Show.BookMyShow.RequestDTOs;

import com.Book_My_Show.BookMyShow.enums.SeatType;
import com.Book_My_Show.BookMyShow.models.Theater;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTheaterSeatDTO {
    private String seatNo;
    private SeatType type;
    private Theater theater;
}
