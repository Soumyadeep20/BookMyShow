package com.Book_My_Show.BookMyShow.service;

import com.Book_My_Show.BookMyShow.RequestDTOs.BookTicketDTO;
import com.Book_My_Show.BookMyShow.models.*;
import com.Book_My_Show.BookMyShow.repository.ShowRepository;
import com.Book_My_Show.BookMyShow.repository.ShowSeatRepository;
import com.Book_My_Show.BookMyShow.repository.TicketRepository;
import com.Book_My_Show.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;
    public String add(BookTicketDTO ticket) {

        String emialBody="";
//    private int seatid;
//    private LocalTime showTime;
//    private LocalDate showDate;
//    private LocalDate bookingDate;
//    private LocalTime bookingTime;
//    private String movieName;
//    private String theaterNameAndAdd;
//    private boolean foodAttached;
//    private Integer totalAmountPaid;
//    private int price;
//    @JoinColumn
//    @ManyToOne
//    private User user;
//    @JoinColumn
//    @ManyToOne
//    private Show show;
        User user = userRepository.findById(ticket.getUserId()).orElse(new User());
        if (user == null) {
            return "User ID: " + Integer.toString(ticket.getUserId()) + " is not exist \n Please Sign-up First";
        }
        Show show = showRepository.findById(ticket.getShowId()).orElse(null);
        if (show == null) {
            return "Movie is not valid";
        }
        Movie movie=show.getMovie();
        List<Integer> wanted=ticket.getSeatid();
        List<ShowSeat> list=show.getSeatList();
        int totalAmount=0;
        for(Integer k: wanted)
        {
            ShowSeat seat=showSeatRepository.findById(k).orElse(null);
            if(seat!=null && list.contains(seat))
            {
                if(!seat.isVaccent())
                {
                    emialBody+="\nSeat Id: "+Integer.toString(k)+" is already booked";
                    wanted.remove(k);
                }
                else
                {
                    seat.setVaccent(false);
                    int amout=seat.getPrice();

                    if(ticket.isFoodAttached())
                    {
                        amout +=200;


                    }
                    totalAmount +=amout;
                    Ticket newTicket=Ticket.builder()
                            .totalAmountPaid(amout)
                            .foodAttached(ticket.isFoodAttached())
                            .movieName(movie.getMovieName())
                            .theaterNameAndAdd(show.getTheater().getName()+"  \naddress: "+show.getTheater().getAddress() )
                            .price(amout)
                            .show(show)
                            .user(user)
                            .seatid(k)
                            .build();
                    user.getTicketList().add(newTicket);
                    show.getTicketList().add(newTicket);
                    //showRepository.save(show);
                    //userRepository.save(user);
                    ticketRepository.save(newTicket);
                }
            }
            else
            {
                emialBody+="\nSeat Id: "+Integer.toString(k)+" is not exist";
                wanted.remove(k);
            }
        }

        emialBody+="\n\n Congradulation "+user.getName()+"!\n"+Integer.toString(wanted.size())+" Ticket Booked Successfully.\n " +
                "Movie name: "+movie.getMovieName()+
                "Theater name"+show.getTheater().getName();
        SimpleMailMessage mail=new SimpleMailMessage();
        mail.setFrom("soumyadeeppodder34@gmail.com");
        mail.setTo(user.getEmail());
        mail.setSubject("Ticket Booked Successfully");
        mail.setText(emialBody);
        javaMailSender.send(mail);


        return "Ticket Booked successfully.\nPlease check email "+user.getEmail();

    }
}
