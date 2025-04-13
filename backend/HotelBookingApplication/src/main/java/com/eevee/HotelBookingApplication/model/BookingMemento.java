package com.eevee.HotelBookingApplication.model;

public class BookingMemento {
    private final String status;
    private final String details;

    public BookingMemento(String status, String details) {
        this.status = status;
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }
}
