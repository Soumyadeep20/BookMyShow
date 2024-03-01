package com.Book_My_Show.BookMyShow.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "shows")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    @JoinColumn
    @ManyToOne
    private Movie movie;
    @JoinColumn
    @ManyToOne
    private Theater theater;
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<Ticket> ticketList=new ArrayList<>();
    //private Theater theater;
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<ShowSeat> seatList=new ArrayList<>();
}
