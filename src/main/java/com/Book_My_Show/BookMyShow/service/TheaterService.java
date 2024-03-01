package com.Book_My_Show.BookMyShow.service;

import com.Book_My_Show.BookMyShow.RequestDTOs.AddTheaterDTO;
import com.Book_My_Show.BookMyShow.RequestDTOs.AddTheaterSeatDTO;
import com.Book_My_Show.BookMyShow.models.Theater;
import com.Book_My_Show.BookMyShow.models.TheaterSeat;
import com.Book_My_Show.BookMyShow.repository.TheaterRepositiry;
import com.Book_My_Show.BookMyShow.repository.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {
    @Autowired
    TheaterRepositiry theaterRepositiry;
    @Autowired
    TheaterSeatRepository theaterSeatRepository;
    public Theater add(AddTheaterDTO theater) {
        Theater newTheater=Theater.builder().address(theater.getAddress()).name(theater.getName()).noOfScreens(theater.getNoOfScreens()).build();
        theaterRepositiry.save(newTheater);
        return newTheater;
    }

    public String delete(int id) {
        theaterRepositiry.deleteById(id);
        return "Deleted successfully";
    }

    public TheaterSeat addSeat(AddTheaterSeatDTO theaterSeat) {
        TheaterSeat newSeat= TheaterSeat.builder()
                .seatNo(theaterSeat.getSeatNo())
                .type(theaterSeat.getType())
                .theater(theaterSeat.getTheater())
                .build();

        theaterSeat.getTheater().getSeatList().add(newSeat);
        theaterSeatRepository.save(newSeat);
        return newSeat;
    }
}
