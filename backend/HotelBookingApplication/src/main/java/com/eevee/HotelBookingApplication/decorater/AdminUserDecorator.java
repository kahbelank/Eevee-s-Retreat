package com.eevee.HotelBookingApplication.decorator;

public class AdminUserDecorator implements IUser {
    private final IUser decoratedUser;

    public AdminUserDecorator(IUser user) {
        this.decoratedUser = user;
    }

    @Override
    public void performAction() {
        decoratedUser.performAction();
        System.out.println("Admin privileges added: Can manage rooms and users.");
    }

    @Override
    public String getFullName() {
        return decoratedUser.getFullName();
    }
}
