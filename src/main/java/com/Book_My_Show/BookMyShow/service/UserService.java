package com.Book_My_Show.BookMyShow.service;

import com.Book_My_Show.BookMyShow.RequestDTOs.AddUserDTO;
import com.Book_My_Show.BookMyShow.models.User;
import com.Book_My_Show.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public String addUser(AddUserDTO user) {
        User newUser=User.builder().name(user.getName()).email(user.getEmail()).build();
        userRepository.save(newUser);
        return "User has been saved to DB with user Id "+newUser.getUserId();
    }

    public User deleteUser(int userId) {
        User user=userRepository.findById(userId).orElse(null);
        userRepository.deleteById(userId);
        return user;
    }
}
