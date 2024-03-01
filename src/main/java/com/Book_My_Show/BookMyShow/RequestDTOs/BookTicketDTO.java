package com.Book_My_Show.BookMyShow.RequestDTOs;

import com.Book_My_Show.BookMyShow.models.Show;
import com.Book_My_Show.BookMyShow.models.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookTicketDTO {
//    private int seatid;
//    private LocalTime showTime;
//    private LocalDate showDate;
//    private LocalDate bookingDate;
//    private LocalTime bookingTime;
//    private String movieName;
//    private String theaterNameAndAdd;
//    private boolean foodAttached;
//    private Integer totalAmountPaid;
//    private int price;
//    @JoinColumn
//    @ManyToOne
//    private User user;
//    @JoinColumn
//    @ManyToOne
//    private Show show;
    private List<Integer> seatid;

    private boolean foodAttached;
    private int userId;
    private int showId;

}
