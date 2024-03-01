package com.Book_My_Show.BookMyShow.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ShowSeat")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int seatid;
    private int price;
    private boolean vaccent;
    @JoinColumn
    @ManyToOne
    private Show show;


}
