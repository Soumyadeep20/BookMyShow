package com.Book_My_Show.BookMyShow.controlers;

import com.Book_My_Show.BookMyShow.RequestDTOs.AddTheaterDTO;
import com.Book_My_Show.BookMyShow.RequestDTOs.AddTheaterSeatDTO;
import com.Book_My_Show.BookMyShow.models.Theater;
import com.Book_My_Show.BookMyShow.models.TheaterSeat;
import com.Book_My_Show.BookMyShow.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    TheaterService theaterService;
    @PostMapping("/add")
    public ResponseEntity<Theater> add(@RequestBody AddTheaterDTO theater)
    {
        Theater newTheater = theaterService.add(theater);
        return new ResponseEntity<>(newTheater, HttpStatus.OK);
    }
    @PostMapping("/addseat")
    public ResponseEntity<TheaterSeat> addSeat(@RequestBody AddTheaterSeatDTO theaterSeat)
    {
        TheaterSeat newTheater = theaterService.addSeat(theaterSeat);
        return new ResponseEntity<>(newTheater, HttpStatus.OK);
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id)
    {
        return theaterService.delete(id);
    }
}
