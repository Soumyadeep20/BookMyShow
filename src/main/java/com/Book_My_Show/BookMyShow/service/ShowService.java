package com.Book_My_Show.BookMyShow.service;

import com.Book_My_Show.BookMyShow.RequestDTOs.AddShowDTO;
import com.Book_My_Show.BookMyShow.RequestDTOs.AddShowSeatDTO;
import com.Book_My_Show.BookMyShow.models.*;
import com.Book_My_Show.BookMyShow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    TheaterSeatRepository theaterSeatRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;
    @Autowired
    TheaterRepositiry theaterRepositiry;

    public  ShowSeat addShowSeat(AddShowSeatDTO seat) {
        Show show=showRepository.findById(seat.getShowId()).orElse(null);
        TheaterSeat thSeat = theaterSeatRepository.findById(seat.getSeatId()).orElse(null);
        String typeOfSeat= String.valueOf(thSeat.getType());
        int price=0;
        if(typeOfSeat.equals("Regular"))
            price=100;
        if(typeOfSeat.equals("Premium"))
            price=150;
        if(typeOfSeat.equals("Gold"))
            price=300;

        ShowSeat newSeat=ShowSeat.builder().price(price).vaccent(true).seatid(seat.getSeatId()).show(show).build();
        List<ShowSeat> ll=show.getSeatList();
        ll.add(newSeat);

        Movie movie=show.getMovie();
        movie.getShowList().add(show);
        showSeatRepository.save(newSeat);
        //showRepository.save(newShow);

        //movieRepository.save(movie);
        return newSeat;

    }

    public Show addShow(AddShowDTO show) {
        Movie m=movieRepository.findById(show.getMovie()).get();
        Theater t=theaterRepositiry.findById(show.getTheater()).get();
        Show newShow=Show.builder().movie(m).theater(t).build();

       List<Show> showListofTh=t.getShowList();
        if(showListofTh==null)
            showListofTh=new ArrayList<>();
       showListofTh.add(newShow);
       t.setShowList(showListofTh);


        List<Show> showListofMo= m.getShowList();
        if(showListofMo==null)
            showListofMo=new ArrayList<>();
        showListofMo.add(newShow);
        m.setShowList(showListofMo);



        showRepository.save(newShow);

        return newShow;
    }

    public String deleteShow(int id) {
        showRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
