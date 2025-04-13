package com.eevee.HotelBookingApplication.decorator;

import com.eevee.HotelBookingApplication.model.User;

public class BasicUser implements IUser {
    private final User user;

    public BasicUser(User user) {
        this.user = user;
    }

    @Override
    public void performAction() {
        System.out.println("Basic user access granted.");
    }

    @Override
    public String getFullName() {
        return user.getFirstName() + " " + user.getLastName();
    }
}
