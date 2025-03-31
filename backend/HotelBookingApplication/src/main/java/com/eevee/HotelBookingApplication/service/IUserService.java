package com.eevee.HotelBookingApplication.service;

import java.util.List;

import com.eevee.HotelBookingApplication.model.User;

public interface IUserService {
    User registerUser(User user);

    List<User> getUsers();

    void deleteUser(String email);

    User getUser(String email);
}
