package com.Book_My_Show.BookMyShow.repository;

import com.Book_My_Show.BookMyShow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
