package com.Book_My_Show.BookMyShow.controlers;

import com.Book_My_Show.BookMyShow.RequestDTOs.AddShowDTO;
import com.Book_My_Show.BookMyShow.RequestDTOs.AddShowSeatDTO;
import com.Book_My_Show.BookMyShow.models.Show;
import com.Book_My_Show.BookMyShow.models.ShowSeat;
import com.Book_My_Show.BookMyShow.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowService showService;
    @PostMapping("/add")
    public ResponseEntity<Show> addShow(@RequestBody AddShowDTO show)
    {
        Show newShow=showService.addShow(show);
        return new ResponseEntity<>(newShow, HttpStatus.OK);
    }
    @PostMapping("/add-seat")
    public void addShowSeat(@RequestBody AddShowSeatDTO seat)
    {
        ShowSeat newSeat=showService.addShowSeat(seat);

    }
    @GetMapping("/delete")
    public String deleteShow(@RequestParam int id)
    {
        return showService.deleteShow(id);
    }
}
