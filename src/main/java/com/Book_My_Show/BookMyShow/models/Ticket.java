package com.Book_My_Show.BookMyShow.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name = "ticket")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private int seatid;
    private LocalTime showTime;
    private LocalDate showDate;
    private LocalDate bookingDate;
    private LocalTime bookingTime;
    private String movieName;
    private String theaterNameAndAdd;
    private boolean foodAttached;
    private Integer totalAmountPaid;
    private int price;
    @JoinColumn
    @ManyToOne
    private User user;
    @JoinColumn
    @ManyToOne
    private Show show;
}
