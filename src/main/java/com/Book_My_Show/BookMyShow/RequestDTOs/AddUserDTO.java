package com.Book_My_Show.BookMyShow.RequestDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddUserDTO {
    private String name;
    private String email;

}
