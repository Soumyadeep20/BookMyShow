package com.Book_My_Show.BookMyShow.controlers;

import com.Book_My_Show.BookMyShow.RequestDTOs.AddUserDTO;
import com.Book_My_Show.BookMyShow.models.User;
import com.Book_My_Show.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/add_user")
    public String addUser(@RequestBody AddUserDTO user)
    {
        return userService.addUser(user);

    }
    @GetMapping("/delete")
    public ResponseEntity<User> deleteUser(@RequestParam int userId)
    {
        User deletedUser =userService.deleteUser(userId);
        return new ResponseEntity<>(deletedUser, HttpStatus.OK);

    }
}
