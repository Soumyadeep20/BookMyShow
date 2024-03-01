package com.Book_My_Show.BookMyShow.models;
import com.Book_My_Show.BookMyShow.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="theaterseat")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TheaterSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType type;
    @JoinColumn
    @ManyToOne
    private Theater theater;
    //private int price;

}
