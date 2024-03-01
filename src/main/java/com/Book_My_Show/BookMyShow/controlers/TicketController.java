package com.Book_My_Show.BookMyShow.controlers;

import com.Book_My_Show.BookMyShow.RequestDTOs.BookTicketDTO;
import com.Book_My_Show.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @PostMapping("/book")
    public String add(@RequestBody BookTicketDTO ticket)
    {
        return ticketService.add(ticket);
    }
}
