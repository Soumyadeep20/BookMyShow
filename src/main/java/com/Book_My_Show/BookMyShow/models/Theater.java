package com.Book_My_Show.BookMyShow.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Theater")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private Integer noOfScreens;
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    List<TheaterSeat> seatList=new ArrayList<>();
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    List<Show> showList=new ArrayList<>();


}
