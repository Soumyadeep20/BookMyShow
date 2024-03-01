package com.Book_My_Show.BookMyShow.repository;

import com.Book_My_Show.BookMyShow.models.ShowSeat;
import com.Book_My_Show.BookMyShow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository  extends JpaRepository<ShowSeat,Integer> {
}
